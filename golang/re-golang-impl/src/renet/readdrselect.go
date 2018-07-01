package renet

import (
	"net"
)

func sortByRFC6724(addrs []IPAddr) {
	if len(addrs) < 2 {
		return
	}
	sortByRFC6724withSrcs(addrs, srcAddrs(addrs))
}

// TODO


