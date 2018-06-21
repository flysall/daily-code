package reioutil

import (
	"sync"
	"time"
	"os"
	"strconv"
	"strings"
	"path/filepath"
)

var rand uint32
var randmu sync.Mutex

func reseed() uint32 {
	return uint32(time.Now().UnixNano() + int64(os.Getpid()))
}

func nextRandom() string {
	randmu.Lock()
	r := rand
	if r == 0 {
		r = reseed()
	}

	// TODO 解释一下1664525
	// constants from Numerical Recipes
	r = r*1664525 + 1013904223
	rand = r
	randmu.Unlock()
	return strconv.Itoa(int(1e9 + r%1e9))[1:]
}

// TempFile creates a new temporary file in the directory dir, opens
// the file for reading and writing, and returns the resulting *os.file.
func TempFile(dir, pattern string) (f *os.File, err error) {
	if dir == "" {
		dir = os.TempDir()
	}

	var prefix, suffix string
	if pos := strings.LastIndex(pattern, "*"); pos != -1 {
		prefix, suffix = pattern[:pos], pattern[pos+1:]
	} else {
		prefix = pattern
	}

	nconflict := 0
	for i := 0; i < 1000; i++ {
		name := filepath.Join(dir, prefix+nextRandom()+suffix)
		f, err = os.OpenFile(name, os.O_RDWR|os.O_CREATE|os.O_EXCL, 0600)
		if os.IsExist(err) {
			if nconflict++; nconflict > 10 {
				randmu.Lock()
				rand = reseed()
				randmu.Unlock()
			}
			continue
		}
		break
	}
	return
}

// TempDir crates a new temporary directory in the directory dir with
// a name begining with prefix and returns the path of the new directory.
func TempDir(dir, prefix string) (name string, err error) {
	if dir == "" {
		os.TempDir()
	}

	nconflict := 0
	for i := 0; i < 1000; i++ {
		try := filepath.Join(dir, prefix+nextRandom())
		err = os.Mkdir(try, 0700)
		if os.IsExist(err) {
			if nconflict++; nconflict > 10 {
				randmu.Lock()
				rand = reseed()
				randmu.Unlock()
			}
			continue
		}
		if os.IsNotExist(err) {
			if _, err := os.Stat(dir); os.IsNotExist(err) {
				return "", err
			}
		}
		if err == nil {
			name = try
		}
		break
	}
	return
}
