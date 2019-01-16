delete from dictionary;
delete from user;
ALTER TABLE dictionary AUTO_INCREMENT = 1;
ALTER TABLE user AUTO_INCREMENT = 1;

insert into user (role) values
('ROLE_ADMIN'),
('USER_ROLE'),
('USER_ROLE'),
('USER_ROLE');

# insert into dictionary (discriminator, name, ext_id) values
# ('ROLE_ADMIN', 'admin name', 1),
# ('ROLE_USER', 'user name', 2);