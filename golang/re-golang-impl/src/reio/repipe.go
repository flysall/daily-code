package reio

import (
	"errors"
	"sync"
	"sync/atomic"
)

type atomicError struct {
	v atomic.Value
}

func (a *atomicError) Store(err error) {
	a.v.Store(struct{ error }{err})
}

func (a *atomicError) Load() error {
	err, _ := a.v.Load().(struct{ error })
	return err.error
}

// ErrClosedPipe is the error used for read or write operations on a closed pipe.
var ErrClosedPipe = errors.New("io: read/write on closed pipe")

// A pipe is the shared pipe structure underlying PipeReader and PipedWriter.
type pipe struct {
	wrMu sync.Mutex  // 读写锁
	wrCh chan []byte // 用于读写的信道
	rdCh chan int    // 从pipe已经读取byte数量

	once sync.Once
	done chan struct{}
	rerr atomicError // 读出错误
	werr atomicError // 写入错误
}

func (p *pipe) Read(b []byte) (n int, err error) {
	select {
	case <-p.done:
		return 0, p.readCloseError()
	default:
	}

	select {
	case bw := <-p.wrCh:
		nr := copy(b, bw)
		p.rdCh <- nr
		return nr, nil
	case <-p.done:
		return 0, p.readCloseError()
	}
}

func (p *pipe) readCloseError() error {
	rerr := p.rerr.Load()
	if werr := p.werr.Load(); rerr == nil && werr != nil {
		return werr
	}
	return ErrClosedPipe
}

func (p *pipe) CloseRead(err error) error {
	if err == nil {
		err = ErrClosedPipe
	}
	p.rerr.Store(err)
	p.once.Do(func() { close(p.done) })
	return nil
}

func (p *pipe) Write(b []byte) (n int, err error) {
	select {
	case <-p.done:
		return 0, p.writeCloseError()
	default:
		p.wrMu.Lock() // 获取读写锁
		defer p.wrMu.Unlock()
	}

	for once := true; once || len(b) > 0; once = false {
		select {
		case p.wrCh <- b:
			nw := <-p.rdCh
			b = b[nw:]
			n += nw
		case <-p.done:
			return n, p.writeCloseError()
		}
	}
	return n, nil
}

func (p *pipe) writeCloseError() error {
	werr := p.werr.Load()
	// 写正确，读错误
	if rerr := p.rerr.Load(); werr == nil && rerr != nil {
		return rerr
	}
	return ErrClosedPipe
}

func (p *pipe) CloseWrite(err error) error {
	if err == nil {
		err = EOF
	}
	p.werr.Store(err)
	p.once.Do(func() {
		close(p.done)
	})
	return nil
}

// A PipeReader is the read half of pipe.
type PipeReader struct {
	// 是结构体指针，而不是结构体
	p *pipe
}

// Read implements the standard Read interface:
func (r *PipeReader) Read(data []byte) (n int, err error) {
	return r.p.Read(data)
}

// Close closes the reader; subsequent writes to write half of the pipe will
// return the error ErrClosedPipe.
func (r *PipeReader) Close() error {
	return r.CloseWithError(nil)
}

func (r *PipeReader) CloseWithError(err error) error {
	return r.p.CloseRead(err)
}

// A PipeWriter is the write half of a pipe.
type PipeWriter struct {
	p *pipe
}

// Write implements the standard Write interface:
func (w *PipeWriter) Write(data []byte) (n int, err error) {
	return w.p.Write(data)
}

// Close closes the writer.
func (w *PipeWriter) Close() error {
	return w.CloseWithError(nil)
}

func (w *PipeWriter) CloseWithError(err error) error {
	return w.p.CloseWrite(err)
}

// Pipe creates a synchronous in-memory pipe.
func Pipe() (*PipeReader, *PipeWriter) {
	p := &pipe{
		wrCh: make(chan []byte),
		rdCh: make(chan int),
		done: make(chan struct{}),
	}
	return &PipeReader{p}, &PipeWriter{p}
}
