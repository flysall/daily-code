package renet

import (
	"time"
	"syscall"
	"io"
)

// netgo and netCgo contain the state of the build tags used to
// build this binary, and whether cgo is available
var (
	netGo bool
	netCgo bool
)

// Addr represents a network end point address.
type Addr interface {
	NetWork() string	// 网络名，如"tcp", "udp"
	String() string		// 地址的字符串表示，如"192.0.0.1:35"
}

type Conn interface {
	Read(b []byte) (n int, err error)

	Write(b []byte) (n int, err error)

	Close() error

	// LocalAddr returns the local network address.
	LocalAddr() Addr

	// RemoteAddr returns the remote network address.
	RemoteAddr() Addr

	// 设置维持该连接的时间
	SetDeadline(t time.Time) error

	SetReadDeadline(t time.Time) error

	SetWriteDeadline(t time.Time) error
}

type conn struct {
	fd *netFD
}

func (c *conn) ok() bool {
	return c != nil && c.fd != nil
}

func (c *conn) Read(b []byte) (int, error) {
	if !c.ok() {
		return 0, syscall.EINVAL
	}
	n, err := c.fd.Read(b)
	if err != nil && err != io.EOF {
		err = &OpError{Op: "read", Net: c.}
	}
}

// TODO Cur



