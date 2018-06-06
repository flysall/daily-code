package main

import "fmt"

type I interface {
    M()
}

func main() {
    var i I
    describe(i) // Now the i is nil, and it will be a runtime error.
    i.M()
}

func describe(i I) {
    fmt.Printf("(%v, %T)\n", i, i)
}
