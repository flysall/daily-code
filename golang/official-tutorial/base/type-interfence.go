package main

import "fmt"

func main() {
    v := 42
    fmt.Printf("v is of type %T\n", v)
    v := 52.00 // It will be a compile-time error
    fmt.Printf("v is of type %T\n", v)
}

