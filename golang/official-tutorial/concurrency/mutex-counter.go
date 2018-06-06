package main

import (
    "fmt"
    "sync"
    "time"
)

// 并发安全
type SafeCounter struct {
    v map[string]int
    mux sync.Mutex
}

func (c *SafeCounter) Inc(key string) {
    c.mux.Lock()
    // 加锁之后只有一个goroutine可以访问c.v
    c.v[key]++
    c.mux.Unlock()
}

func (c *SafeCounter) Value(key string) int {
    c.mux.Lock()
    defer c.mux.Unlock()
    return c.v[key]
}

func main() {

