package reio_test

import (
	"testing"
	"strings"
	."reio"
	"bytes"
	"fmt"
	"crypto/sha1"
	"runtime"
)

func TestMultiReader(t *testing.T) {
	var mr Reader
	var buf []byte
	nread := 0
	// 闭包
	withFooBar := func(tests func()) {
		r1 := strings.NewReader("foo ")
		r2 := strings.NewReader("")
		r3 := strings.NewReader("bar")
		mr = MultiReader(r1, r2, r3)
	}
	expectRead := func(size int, expected string, eerr error) {
		nread++
		n, gerr := mr.Read(buf[0:size])
		if n != len(expected) {
			t.Errorf("#%d, expedted %d bytes; got %d",
				nread, len(expected), n)
		}
		got := string(buf[0:n])
		if got != expected {
			t.Errorf("#%d, expected %q; got %q",
				nread, expected, got)
		}
		if gerr != eerr {
			t.Errorf("#%d, expected error %v; got %v",
				nread, eerr, gerr)
		}
		buf = buf[n:]
	}
	withFooBar(func() {
		expectRead(2, "fo ", nil)
		expectRead(5, "o ", nil)
		expectRead(5, "bar", nil)
		expectRead(5, "", EOF)
	})
	withFooBar(func() {
		expectRead(4, "foo ", nil)
		expectRead(1, "b", nil)
		expectRead(3, "ar", nil)
		expectRead(1, "", EOF)
	})
	withFooBar(func() {
		expectRead(5, "foo ", nil)
	})
}

func TestMultiWriter(t *testing.T) {
	sink := new(bytes.Buffer)
	// Hide bytes.Buffer's WriteString method.
	testMultiWriter(t, struct {
		Writer
		fmt.Stringer
	}{sink, sink})
}


func testMultiWriter(t *testing.T, sink interface {
	Writer
	fmt.Stringer
}) {
	// 产生一个hash值
	sha1 := sha1.New()
	// TODO MultiWriter参数没太看懂
	mw := MultiWriter(sha1, sink)

	sourceString := "My input text."
	source := strings.NewReader(sourceString)
	written, err := Copy(mw, source)

	if written != int64(len(sourceString)) {
		t.Errorf("short write of %d, not %d", written, len(sourceString))
	}

	if err != nil {
		t.Errorf("unexpected error: %v", err)
	}

	// sha1用十六进制表示
	sha1hex := fmt.Sprintf("%x", sha1.Sum(nil))
	if sha1hex != "01cb303fa8c30a64123067c5aa6284ba7ec2d31b" {
		t.Error("incorrect sha1 Value")
	}

	if sink.String() != sourceString {
		t.Errorf("expected %q; got %q", sourceString, sink.String())
	}
}

// 这个函数签名和Writer接口的Write方法一致
type writeFunc func(p []byte) (int, error)

func (f writeFunc) Write(p []byte) (int, error) {
	// 类型转换？
	return f(p)
}

// Test that MultiWriter properly flattens chained multiWriters
func TestMultiWriterSingleChainFlatten(t *testing.T) {
	pc := make([]uintptr, 1000) // 1000 should fit the full stack
	n := runtime.Callers(0, pc)
	var myDepth = callDepth(pc[:n])
	var writeDepth int
	var w Writer = MultiWriter(writeFunc(func(p []byte) (int, error) {
		n := runtime.Callers(1, pc)
		writeDepth += callDepth(pc[:n])
		return 0, nil
	}))

	mw := w
	// chain a bunch o multiWriters
	for i := 0; i < 100; i++ {
		mw = MultiWriter(w)
	}

	mw = MultiWriter(w, mw, w, mw)
	mw.Write(nil)

	if writeDepth != 4*(myDepth+2) {
		t.Errorf("multiWriter did not flatten chained multiWriters: expected writeDepth %d, got %d",
			4*(myDepth+2), writeDepth)
	}
}


func callDepth(callers []uintptr) (depth int) {
	// TODO There isn't CallersFramew function in go1.6.2
	/*
	frames := CallersFrames(callers)
	more := true
	for more {
		_, more = frames.Next()
		depth++
	}
	*/
	return
}

