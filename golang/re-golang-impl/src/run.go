package main

import (
	"net"
	"fmt"
)

func main() {
	laddr, _ := net.ResolveIPAddr("ip", "192.168,1.1")
	raddr, _ := net.ResolveIPAddr("ip", "192.168.1.0")
	ipConn, _ := net.DialIP("ip", laddr, raddr)
	fmt.Println(ipConn)
}
