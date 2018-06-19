package main

import (
	"reio"
	"fmt"
)

func writeToPipe(w reio.Writer, data []byte) {
	w.Write(data)
}

func main() {
	pr, pw := reio.Pipe()
	in := []byte("Welcome to use reio.Pipe()")
	go writeToPipe(pw, in)
	buf := make([]byte, 64)
	_, rerr := pr.Read(buf)
	if rerr != nil {
		fmt.Println(rerr)
	}
	fmt.Println(string(buf))
	pr.Close()
	fmt.Printf("type of pr and pw is: %T %T\n", pr, pw)
}
