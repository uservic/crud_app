delete from dictionary;
delete from user;
delete from dt_seq_gen;
ALTER TABLE dictionary AUTO_INCREMENT = 1;
ALTER TABLE user AUTO_INCREMENT = 1;

insert into dictionary (discriminator, name, ext_id) values
('Role', 'USER', 1),
('Role', 'ADMIN', 2);

insert into user (login, password, role) values
('Joe', '$2a$10$JOnSNhONy3md7cB0rkxBmO/IZY5ur/ZQ4vO/sJ18rVn31jc0.PQ5u', 2), /*password 11111*/
('Bob', '$2a$10$vKTJezToFLCyIaCenFIMcuNPx3LtHiYQsd1khA4jVF70D59/lsZ2.', 1), /*password 22222*/
('Ann', '{noop}33333', 1),
('Zoe', '{noop}44444', 1);

insert into dt_seq_gen (name, counter) VALUES
('role', 2);
