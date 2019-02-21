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


insert into movies (id, title, description) values
(1, 'Movie_Title_1', 'Description_1'),
(2, 'Movie_Title_2', 'Description_2');

insert into hall (id, hall_name, rows_quant, seats_in_row) values
(1, 'Hall_A', 2, 2);

insert into seats (id, row, number, hall_id) values
(1, 1, 1, 1),
(2, 1, 2, 1),
(3, 2, 1, 1),
(4, 2, 2, 1);

insert into movie_sessions (id, date, time, movie_id, hall_id) VALUES
(1, '2019-02-01', '12:00:00', 1, 1),
(2, '2019-02-01', '15:00:00', 1, 1),
(3, '2019-02-02', '22:00:00', 2, 1),
(4, '2019-02-02', '23:30:00', 2, 1),
(5, '2019-02-03', '09:00:00', 1, 1);

insert into price_categories (id, cat_type, price) VALUES
(1, 'morning', 150),
(2, 'midday', 250),
(3, 'afternoon', 350);

insert into orders (id, price_cat_id, user_id, session_id, seat_id) VALUES
(1, 2, 1, 1, 1),
(2, 2, 1, 1, 2),
(3, 3, 2, 2, 3),
(4, 3, 3, 2, 4);
