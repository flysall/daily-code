package main

import "fmt"

func main() {
	nums := make([]int64, 12)
	fmt.Println(nums)
	modslice(nums)
	fmt.Println(nums)
}

func modslice(src []int64) {
	src[0] = 1
}
