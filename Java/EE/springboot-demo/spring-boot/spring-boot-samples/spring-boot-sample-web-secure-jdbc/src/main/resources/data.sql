insert into users(username, password, enable) values('user', '{noop}user', true);

insert into authorities(username, authority) values ('user', 'ROLE_ADMIN');