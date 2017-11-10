import struct
print(struct.pack('>I', 10240099))
print(struct.unpack('>IH', b'\x00\x9c@c'))