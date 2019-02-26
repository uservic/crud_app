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
