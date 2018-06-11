package main

import (
    "fmt"
)

func main() {
    val := "flysall"
    str, ok := val.(string)
    if ok {
        fmt.Printf("字符串的值为 %q\n", str)
    } else {
        fmt.Printf("该值为非字符串\n")
    }
}
