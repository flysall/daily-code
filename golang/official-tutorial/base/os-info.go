package main

import (
	"fmt"
	"os"
)	

func main() {
	var (
		home   = os.Getenv("HOME")
		user   = os.Getenv("USER")
		gopath = os.Getenv("GOPATH")
	)
	fmt.Println("$HOME is:", home, "| $USER is:", user, "| $GOPATH is:", gopath)
}

