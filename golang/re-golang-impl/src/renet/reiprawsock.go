package renet

import (
	"context"
	"net"
	"syscall"
)

// IPAddr represents the address of an IP end point.
type IPAddr struct {
	IP IP
	Zone string
}

// NetWork returns the address's network name, "ip".
func (a *IPAddr) NetWork() string {
	return "ip"
}

func (a *IPAddr) String() string {
	if a == nil {
		return "<nil>"
	}
	ip := ipEmptyString(a.IP)
	if a.Zone != "" {
		return ip + "%" + a.Zone
	}
	return ip
}

func (a *IPAddr) isWildcard() bool {
	if a == nil || a.IP == nil {
		return true
	}
	return a.IP.IsUnsepecified()
}

func (a *IPAddr) opAddr() Addr {
	if a == nil {
		return nil
	}
	return a
}

// ResoloveIpAddr returns an address of IP end point.
func ResolveIPAddr(network, address string) (*IPAddr, error) {
	if network == "" {
		// 网络名称默认为ip
		network = "ip"
	}
	afnet, _, err := parseNetWork(context.Background(), network, false)
	if err != nil {
		return nil, err
	}
	switch afnet {
	case "ip", "ip4", "ip6":
	default:
		return nil, UnknownNetworkError(network)
	}
	addrs, err := DefaultResolver.internetAddrList(context.Background(), afnet, address)
	if err != nil {
		return nil, err
	}
	return addrs.forResolve(network, address).(*IPAddr), nil
}

// IPConn is the implementation of the Conn and PacketConn interfaces for
// IP network conections.
type IPConn struct {
	conn	// conn是一个net包下私有的结构体，IPConn等同于conn，但访问权限为公有
}

func (c *IPConn) SyncallConn() (syscall.RawConn, error) {
	if !c.ok() {
		return nil, syscall.EINVAL
	}
	return newRawConn(c.fd)
}


// ReadFromIP acts like RedFrom but returns an IPAddr.
func (c *IPConn) ReadFromIP(b []byte) (int, *IPAddr, error) {
	if !c.ok() {
		return 0, nil, syscall.EINVAL
	}
	n, addr, err := c.readFrom(b)
	if err != nil {
		err = &OpError{Op: "read", Net: c.fd.net, Source: c.fd.laddr, Addr: c.fd.raddr, Err: err}
	}
	if addr == nil {
		return n, nil, err
	}
	return n, addr, err
}

// ReadFrom implements the PacketConn ReadFrom method.
func (c *IPConn) ReadFrom(b []byte) (int, Addr, error) {
	if !c.ok() {
		return 0, nil, syscall.EINVAL
	}
	n, addr, err := c.readFrom(b)
	if err != nil {
		err = &OpError{Op: "read", Net: c.fd.net, Source: c.fd.laddr, Addr: c.fd.raddr, Err: err}
	}
	if addr == nil {
		return 0, nil, err
	}
	return n, addr, err
}

// TODO
