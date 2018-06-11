package reio_test

import (
	"bytes"
	."reio"
	"testing"
)

type Buffer struct {
	bytes.Buffer
	ReaderFrom
	WriterTo
}

func TestCopy(t *testing.T) {
	rb := new(Buffer)
	wb := new(Buffer)
	rb.WriteString("hello, world.")
	Copy(wb, rb)
	if wb.String() != "hello, world." {
		t.Errorf("Copy didn't work properly")
	}
}

func TestCopyNegative(t *testing.T) {
	rb := new(Buffer)
	wb := new(Buffer)
	rb.WriteString("hello")
	Copy(wb, &LimitedReader{R: rb, N: -1})
	if wb.String() != "" {
		t.Errorf("Copy on limitedReader with N < 0 copied data")
	}

	CopyN(wb, rb, -1)
	if wb.String() != "" {
		t.Errorf("CopyN with N < 0 copied data")
	}
}

func TestCopyBuffer(t *testing.T) {
	rb := new(Buffer)
	wb := new(Buffer)
	rb.WriteString("hello, world.")
	CopyBuffer(wb, rb, make([]byte, 1))
	if wb.String() != "hello, world." {
		t.Errorf("CopyBuffer didn't work properly")
	}
}