import hashlib

md5 = hashlib.md5()
md5.update('how to use md5 in python hashlib?'.encode('utf-8'))
print(md5.hexdigest())

print('---->')
shal =  hashlib.sha1()
shal.update('how to use shal in'.encode('utf-8'))
shal.update('python hashlib?'.encode('utf-8'))
print(shal.hexdigest())