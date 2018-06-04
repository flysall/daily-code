package main

import "fmt"

func main() {
    defer fmt.Println("outer 666")
    fmt.Println("inner 666")
}
