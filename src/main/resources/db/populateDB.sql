delete from dictionary;
delete from user;
ALTER TABLE dictionary AUTO_INCREMENT = 1;
ALTER TABLE user AUTO_INCREMENT = 1;

insert into dictionary (discriminator, name, ext_id) values
('Role', 'USER', 1),
('Role', 'ADMIN', 2);

insert into user (login, password, role) values
('Joe', '11111', 2),
('Bob', '22222', 1),
('Ann', '33333', 1),
('Zoe', '44444', 1);