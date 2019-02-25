delete from orders;
delete from seats;
delete from price_categories;
delete from movie_sessions;
delete from hall;
delete from movies;

delete from dictionary;
delete from users;
delete from dt_seq_gen;
ALTER SEQUENCE dictionary_id_seq RESTART WITH 1;
ALTER SEQUENCE users_id_seq RESTART WITH 1;
ALTER SEQUENCE movies_id_seq RESTART WITH 1;
ALTER SEQUENCE movie_sessions_id_seq RESTART WITH 1;
ALTER SEQUENCE hall_id_seq RESTART WITH 1;
ALTER SEQUENCE seats_id_seq RESTART WITH 1;
ALTER SEQUENCE price_categories_id_seq RESTART WITH 1;
ALTER SEQUENCE orders_id_seq RESTART WITH 1;

insert into dictionary (discriminator, name, ext_id) values
('Role', 'USER', 1),
('Role', 'ADMIN', 2);

insert into users (login, password, role) values
('Joe', '$2a$10$JOnSNhONy3md7cB0rkxBmO/IZY5ur/ZQ4vO/sJ18rVn31jc0.PQ5u', 2), /*password 11111*/
('Bob', '$2a$10$vKTJezToFLCyIaCenFIMcuNPx3LtHiYQsd1khA4jVF70D59/lsZ2.', 1), /*password 22222*/
('Ann', '{noop}33333', 1),
('Zoe', '{noop}44444', 1);

insert into dt_seq_gen (name, counter) VALUES
('role', 2);


insert into movies (title, description) values
('Amelie', 'Amelie description'),
('Spiderman 2', 'Spiderman 2 description');

insert into hall (hall_name, rows_quant, seats_in_row) values
('Hall_A', 2, 2);

insert into seats (row, number, hall_id) values
(1, 1, 1),
(1, 2, 1),
(2, 1, 1),
(2, 2, 1);

insert into movie_sessions (date, time, movie_id, hall_id) VALUES
('2019-02-01', '12:00:00', 1, 1),
('2019-02-01', '15:00:00', 1, 1),
('2019-02-02', '22:00:00', 2, 1),
('2019-02-02', '23:30:00', 2, 1),
('2019-02-03', '09:00:00', 1, 1);

insert into price_categories (cat_type, price) VALUES
('morning', 150),
('midday', 250),
('afternoon', 350);

insert into orders (price_cat_id, user_id, session_id, seat_id) VALUES
(2, 1, 1, 1),
(2, 1, 1, 2),
(3, 2, 2, 3),
(3, 3, 2, 4);
