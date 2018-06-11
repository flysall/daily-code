package main

import "fmt"

type A struct {
    a int
}

func (a *A) Printa() {
    fmt.Printf("%d\n", a.a)
}

type B struct {
    A    // It's amazing!
    n string
}

func main() {
    b := B{}
    b.Printa()
    b.A.a = 5
    fmt.Printf("%d\n", b.a)
}
