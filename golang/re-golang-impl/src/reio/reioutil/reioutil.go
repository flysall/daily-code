package reioutil

import (
	"reio"
	"bytes"
	"os"
	"sort"
)

// readAll reads from r until an error or EOF and returns the dta it read
// from the buffer.
func readAll(r reio.Reader, capacity int64) (b []byte, err error) {
	var buf bytes.Buffer
	// If the buffer overflows, we get bytes.
	defer func() {
		e := recover()
		if e == nil {
			return
		}
		if panicErr, ok := e.(error); ok && panicErr == bytes.ErrTooLarge {
			err = panicErr
		} else {
			panic(e)
		}
	}()
	// 两次转型？ int64 -> int -> int64?
	// Grow接收的参数类型为int而非int64
	if int64(int(capacity)) == capacity {
		buf.Grow(int(capacity))
	}
	_, err = buf.ReadFrom(r)
	return buf.Bytes(), err
}

// ReadAll reads from r until an error or EOF and returns the data it read.
func ReadAll(r reio.Reader) ([]byte, error) {
	return readAll(r, bytes.MinRead)
}

// ReadFile reads fille named by filename and returns the contents.
func ReadFile(filename string) ([]byte, error) {
	f, err := os.Open(filename)
	if err != nil {
		return nil, err
	}
	defer f.Close()

	var n int64 = bytes.MinRead

	if fi, err := f.Stat(); err == nil {
		if size := fi.Size() + bytes.MinRead; size > n {
			n = size
		}
	}
	return readAll(f, n)
}

// WriteFile writes data to a file named by filename.
func WriteFile(filename string, data []byte, perm os.FileMode) error {
	f, err := os.OpenFile(filename, os.O_WRONLY | os.O_CREATE | os.O_TRUNC, perm)
	if err != nil {
		return nil
	}
	n, err := f.Write(data)
	if err == nil && n < len(data) {
		err = reio.ErrShortWrite
	}
	if err1 := f.Close(); err == nil {
		err = err1
	}
	return err
}

// byName implements sort.Interface.
type byName []os.FileInfo

func (f byName) Len() int {
	return len(f)
}

func (f byName) Less(i, j int) bool {
	return f[i].Name() < f[j].Name()
}

func (f byName) Swap(i, j int) {
	f[i], f[j] = f[j], f[i]
}

// ReadDir reads directory named by dirname and returns a list of
// directory entries sorted by fillename.
func ReadDir(dirname string) ([]os.FileInfo, error) {
	f, err := os.Open(dirname)
	if err != nil {
		return nil, err
	}
	list, err := f.Readdir(-1)
	if err != nil {
		return nil, err
	}
	sort.Sort(byName(list))
	return list, nil
}