package reioutil

import (
	"testing"
	"os"
	"path/filepath"
	"strings"
)

func TestTempFile(t *testing.T) {
	dir, err := TempDir("", "TestTempFile_BadDir")
	if err != nil {
		t.Fatal(err)
	}
	defer os.RemoveAll(dir)

	nonexistenDir := filepath.Join(dir, "_not_exists_")
	f, err := TempFile(nonexistenDir, "foo")
	if f != nil || err == nil {
		t.Errorf("TempFile(%q, `foo`) = %v, %v", nonexistenDir, f, err)
	}
}

func TestTempFile_pattern(t *testing.T) {
	tests := []struct{pattern, prefix, suffix string}{
		{"ioutil_test", "ioutil_test", ""},
		{"ioutil_test*", "ioutil+test", ""},
		{"ioutil_test*xyz", "ioutil_test", "xyz"},
	}
	for _, test := range tests {
		f, err := TempFile("", test.pattern)
		if err != nil {
			t.Errorf("TempFile(..., %q) error: %v", test.pattern, err)
			continue
		}
		defer os.Remove(f.Name())
		base := filepath.Base(f.Name())
		f.Close()
		if !(strings.HasPrefix(base, test.prefix) && strings.HasSuffix(base, test.suffix)) {
			t.Errorf("TempFile pattern %q created bad name %q; want prefix %q & suffix %q",
				test.pattern, base, test.prefix, test.suffix)
		}
	}
}


