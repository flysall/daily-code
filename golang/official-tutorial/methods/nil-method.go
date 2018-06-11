package main

import "fmt"

type A struct {
    a int
}

func (a *A) Printa() {
    if a == nil {
        fmt.Println("a is nil")
    } else {
        fmt.Printf("%d\n", a.a)
    }
}

func main() {
    var a *A = nil
    a.Printa()
}
