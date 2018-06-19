// Copyright 2009 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

// Package reio provides basic interfaces to I/O primitives.
// Its primary job is to wrap existing implementations of such primitives,
// such as those in package os, into shared public interfaces that
// abstract the functionality, plus some other related primitives.
//
// Because these interfaces and primitives wrap lower-level operations with
// various implementations, unless otherwise informed clients should not
// assume they are safe for parallel execution.
package reio

import (
    "errors"
)

const (
    SeekStart = 0 // seek relative to the origin of the file.
    SeekCurrent = 1 
    SeekEnd = 2
)

// ErrShortWrite means that a write accpted fewer bytes than requested
// but failed to return an explicit error.
var ErrShortWrite = errors.New("short write")

var ErrShortBuffer = errors.New("short buffer")

var EOF = errors.New("EOF")

var ErrUnexpectedEOF = errors.New("unexpected EOF")

var ErrNoProgress = errors.New("multiple Read calls return no data or error")

// Reader is the interface that wraps the basic Read method.
type Reader interface {
    Read(p []byte) (n int, err error)
}

// Writer is the interface that wraps the basic Write method.
type Writer interface {
    Write(p []byte) (n int, err error)
}

// Closer is the interface that wraps the basic Close method.
type Closer interface {
    Close() error
}

// Seeker is the interface that wraps the basic Seek method.
type Seeker interface {
    Seek(offset int64, whence int) (int64, error)
}


// ReadWriter is the interface that groups the basic Read and Writ methods.
type ReadWriter interface {
    Reader
    Writer
}

// ReadCloser is the interface the groups the basic Read and Close methos.
type ReadClose interface {
    Reader
    Closer
}

//
type WriteCloser interface {
    Writer
    Closer
}

// 
type ReadWriteCloser interface {
    Reader
    Writer
    Closer
}

// 
type ReadSeeker interface {
    Reader
    Writer
    Closer
}

// 
type WriteSeeker interface {
    Writer
    Seeker
}

//
type ReadWriteSeeker interface {
    Reader
    Writer
    Seeker
}

// 
type ReaderFrom interface {
    ReadFrom(r Reader) (n int64, err error)
}

//
type WriterTo interface {
    WriteTo(w Writer) (n int64, err error)
}

//
type ReaderAt interface {
    ReadAt(p []byte, off int64) (n int, err error)
}

//
type WriterAt interface {
    WriteAt(p []byte, off int64) (n int, err error)
}

//
type ByteReader interface {
    ReadByte() (byte, error)
}


// 
type ByteScanner interface {
    ByteReader
    UnReadByte() error
}

//
type ByteWriter interface {
    WriteByte(c byte) error
}

//
type RuneReader interface {
    ReadRune() (r rune, size int, err error)
}

//
type RuneScanner interface {
    RuneReader
    UnreadRune() error
}

type StringWriter interface {
    WriteString(s string) (n int, err error)
}

// WriteString writes the contents of the string s to w, which accepts a slice of bytes.
func WriteString(w Writer, s string) (n int, err error) {
    // 类型断言
    if sw, ok := w.(StringWriter); ok {
        return sw.WriteString(s)
    }
    // 不可转型为StringWriter, 将string转型为[]byte切片
    return w.Write([]byte(s))
}


// ReadAtLeast reads from r into buf until it has read at least min bytes.
func ReadAtLeast(r Reader, buf []byte, min int) (n int, err error) {
	// 当前切片中元素个数小于min则返回ErrShortBuffer?
	// or缓冲区大小小于min则返回ErrShortBuffer?
	if len(buf) < min {
	    return 0, ErrShortBuffer
	}
	for n < min && err == nil {
	    var nn int
	    // buf是切片，可不断增长，n记录了上次Read时的位置
	    nn, err = r.Read(buf[n:])
	    n += nn
    }
    if n >= min {
        err = nil
    } else if n > 0 && err == EOF {
        // 不可预知的错误
        err = ErrUnexpectedEOF
    }
    return
}


// ReadFull reads exactly len(buf) bytes from r into buf.
func ReadFull(r Reader, buf []byte) (n int, err error) {
    return ReadAtLeast(r, buf, len(buf))
}

// CopyN copies n bytes (or until an error) from src to dst.
func CopyN(dst Writer, src Reader, n int64) (written int64, err error) {
    written, err = Copy(dst, LimitReader(src, n))
    if written == n {
        return n, nil
    }
    if written < n && err == nil {
        // src stopped early; must have been EOF
        err = EOF
    }
    return
}

// Copy copies from src to dst until either EOF is reached on src or an error occurs.
func Copy(dst Writer, src Reader) (written int64, err error) {
    // copyBuffer是非公有函数
    return copyBuffer(dst, src, nil);
}

// CopyBuffer is identical to Copy except that it stages through the provided bufferr
// rather than allocating a temporary one.
func CopyBuffer(dst Writer, src Reader, buf []byte) (writen int64, err error) {
    // 缓冲区为空
    if buf != nil && len(buf) == 0 {
        panic("empty buffer in reio.CopyBuffer")
    }
    return copyBuffer(dst, src, buf)
}

// copyBuffer is the actual implementation of Copy and CopyBuffer.
func copyBuffer(dst Writer, src Reader, buf []byte) (written int64, err error) {
    // If the reader has a WriteTo method, use it to do the copy.
    // 避免创建新的reader
    // 类型断言
    if wt, ok := src.(WriterTo); ok {
        return wt.WriteTo(dst)
    }
    // 同上
    if rt, ok := dst.(ReaderFrom); ok {
        return rt.ReadFrom(src)
    }

    if buf == nil {
        // 开辟32kb大小的内存
        size := 32 * 1024
        if l, ok := src.(*LimitedReader); ok && int64(size) > l.N {
            if l.N < 1 {
                size = 1
            } else {
                size = int(l.N)
            }
        }
        // 创建大小为size的切片
        buf = make([]byte, size);
    }

    for {
        // 将数据从src读入buf
        nr, er := src.Read(buf)
        if nr > 0 {
            // 将数据从buf写入dst
            nw, ew := dst.Write(buf[0:nr])
            if nw > 0 {
                written += int64(nw)
            }
            if ew != nil {
                err = ew
                break
            }
            if nr != nw {
                err = ErrShortWrite
                break
            }
        }
        if er != nil {
            if er != EOF {
                err = er
            }
            break
        }
    }
    return written, err
}

// LimitReader returns a Reader that reads from r
// but stops with EOF after n bytes.
func LimitReader(r Reader, n int64) Reader {
    return &LimitedReader{r, n}
}

// A LimitedReader reads from R but limits the amount of data returned
// to just N bytes.
type LimitedReader struct {
    R Reader    // underlying reader
    N int64 // max bytes remaining
}


func (l *LimitedReader) Read(p []byte) (n int, err error) {
    if l.N <= 0 {
        return 0, EOF
    }
    if int64(len(p)) > l.N {
        // 切片的长度大于LimitedReader的最大长度
        p = p[0:l.N]
    }
    n, err = l.R.Read(p)
    // 计算LimitedReader的剩余最大长度
    l.N -= int64(n)
    return
}

// NewSectionReader returns a SectionReader that reads from r
// starting at offset and stops with EOF after n bytes.
func NewSectionReader(r ReaderAt, off int64, n int64) *SectionReader {
    return &SectionReader{r, off, off, off + n}
}


// SectionReader implements Read, Seek, and ReadAt on a section of an
// underlying ReadAt.
type SectionReader struct {
    // 全为小写，为该包私有
    r ReaderAt
    base int64  // 起始位置
    off int64   // 相对起始位置的偏移
    limit int64 // 终止位置
}

func (s *SectionReader) Read(p []byte) (n int, err error) {
    if s.off >= s.limit {
        return 0, EOF
    }
    if max := s.limit - s.off; int64(len(p)) > max {
        p = p[0:max]
    }
    n, err = s.r.ReadAt(p, s.off)
    s.off += int64(n)
    return
}

var errWhence = errors.New("Seek: invalid whence")
var errOffset = errors.New("Seek: invalid offset")

func (s *SectionReader) Seek(offset int64, whence int) (int64, error) {
    switch whence {
    default:
        return 0, errWhence
    case SeekStart:
        offset += s.base
    case SeekCurrent:
        offset += s.off
    case SeekEnd:
        offset += s.limit
    }
    if offset < s.base {
        return 0, errOffset
    }
    s.off = offset
    return offset - s.base, nil
}

func (s *SectionReader) ReadAt(p []byte, off int64) (n int, err error) {
    if off < 0 || off >= s.limit - s.base {
        return 0, EOF
    }
    off += s.base
    if max := s.limit - off; int64(len(p)) > max {
        p = p[0:max]
        n, err = s.r.ReadAt(p, off)
        if err == nil {
            err = EOF
        }
        return n, err
    }
    return s.r.ReadAt(p, off)
}

// Size return the size of the section in bytes.
func (s *SectionReader) Size() int64 {
    return s.limit - s.base
}

// TeeReader returns a Reader that writes to w what it reads from r.
func TeeReader(r Reader, w Writer) Reader {
    return &teeReader{r, w}
}

type teeReader struct {
    r Reader
    w Writer
}


func (t *teeReader) Read(p []byte) (n int, err error) {
    n, err = t.r.Read(p)
    if n > 0 {
        if n, err := t.w.Write(p[:n]); err != nil {
            return n, err
        }
    }
    return
}

