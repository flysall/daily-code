package main

import "fmt"

type I interface {
    M()
}

type T struct {
    S string
}

// 此方法表明类型T实现了接口I.
func (t T) M() {
    fmt.Println(t.S)
}

func main() {
    var i I = T{"flysall"}
    i.M()
}
