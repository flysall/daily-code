from datetime import datetime
now = datetime.now()
print(now)
print(type(now))

dt = datetime(2015, 4, 19, 12, 20)
dt.timestamp()
print(type(dt))


t = 19484584.0
print(datetime.fromtimestamp(t))
print(datetime.utcfromtimestamp(t))

print('---->')
cday = datetime.strptime('2015-6-1 18:19:59', '%Y-%m-%d %H:%M:%S')
print(cday)

print('----->')
now = datetime.now()
print(now.strftime('%a, %b %d %H:%M'))

print('----->')
from datetime import timedelta, timezone
now = datetime.now()
print(now)
print(now+timedelta(hours=10))
print('-->')
tz_utc_8 = timezone(timedelta(hours=8))
now = datetime.now
print(now)
print('---->')

import re
def to_timestamp(dt_str, tz_str):
	get_time = datetime.strptime(dt_str, '%Y-%m-%d %h:%M:%S')
	ut_int = re.match(r'^UTC([+|-]\d{1,2}):00$', tz_str).group(1)
	tz_utc = timezone(timedelta(hours=int(utc_int)))
	dt = get_time.replace(tzinfo=tz_utc)
	return dt.timestamp()