package reio

type eofReader struct{}

func (eofReader) Read([]byte) (int, error) {
	return 0, EOF
}

// 包含多个Reader的Reader
type multiReader struct {
	readers []Reader
}

// multiReader实现了Reader接口
func (mr *multiReader) Read(p []byte) (n int, err error) {
	for len(mr.readers) > 0 {
		if len(mr.readers) == 1 {
			if r, ok := mr.readers[0].(*multiReader); ok {
				mr.readers = r.readers
				continue
			}
		}
		n, err = mr.readers[0].Read(p)
		if err == EOF {
			// use eofReader instead of nil to avoid nil panic after
			// performing flatten
			mr.readers[0] = eofReader{}
			mr.readers = mr.readers[1:]
		}
		// 正常读取的状态
		if n > 0 || err != EOF {
			if err == EOF && len(mr.readers) > 0 {
				// Don't return EOF yet. More readers remain.
				err = nil
			}
			return
		}
	}
	return 0, EOF
}

// MultiReader returns a Reader that's the logical concatenation of the provided
// input readers.
func MultiReader(readers ...Reader) Reader {
	r := make([]Reader, len(readers))
	copy(r, readers)
	return &multiReader{r}
}

type multiWriter struct {
	writers []Writer
}

func (t *multiWriter) Write(p []byte) (n int, err error) {
	for _, w := range t.writers {
		n, err = w.Write(p)
		if err != nil {
			return
		}
		if n != len(p) {
			err = ErrShortWrite
			return
		}
	}
	return len(p), nil
}

// TODO 核实源码
//var _ stringWriter = (*multiWriter)(nil)

func (t *multiWriter) WriteString(s string) (n int, err error) {
	var p []byte // lazily initialized
	for _, w := range t.writers {
		// TODO 检查转型
		if sw, ok := w.(StringWriter); ok {
			n, err = sw.WriteString(s)
		} else {
			if p == nil {
				p = []byte(s)
			}
			n, err = w.Write(p)
		}
		if err != nil {
			return
		}
		if n != len(s) {
			err = ErrShortWrite
			return
		}
	}
	return len(s), nil
}

// MultiWriter creates a writer that duplicates its writes to all the provided writers,
// similar to the Unix tee(1) command.
func MultiWriter(writers ...Writer) Writer {
	allWriters := make([]Writer, 0, len(writers))
	for _, w := range writers {
		// 如果该Writer是multiWriter(类型断言)
		if mw, ok := w.(*multiWriter); ok {
			allWriters = append(allWriters, mw.writers...)
		} else {
			allWriters = append(allWriters, w)
		}
	}
	return &multiWriter{allWriters}
}
