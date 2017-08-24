#server.py

from wsgiref.simple_server import make_server
from myweb import application

httpd = make_server('', 9000, application)
httpd.serve_forever()