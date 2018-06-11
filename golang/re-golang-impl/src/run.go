package main

import (
	"reio"
	"fmt"
)

func main() {
	limitedReader := reio.LimitedReader{}
	fmt.Printf("The type of limitedReader is %T", limitedReader)
}
