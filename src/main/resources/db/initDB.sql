drop table if exists orders;
drop table if exists price_categories;
drop table if exists seats;
drop table if exists movie_sessions;
drop table if exists hall;
drop table if exists movies;

drop table if exists users;
drop table if exists dictionary;
drop table if exists dt_seq_gen;

create table dictionary
(
	id serial
		constraint dictionary_pk
			primary key,
	discriminator varchar(30) not null,
	name varchar(255) not null,
	ext_id int not null
);

create table users
(
	id serial
		constraint users_pk
			primary key,
	login varchar(31) not null,
	password varchar(255) not null,
	role int null,
	constraint users_login_uindex
		unique (login),
	constraint users_role_fk
		foreign key (role) references dictionary (id)
			on delete set null
);

create table dt_seq_gen
(
	name varchar(255)
		constraint dt_seq_gen_pk
			primary key,
	counter int not null
);

/*Preliminary MovieTheatreTables initialization*/

create table movies
(
  id serial
    constraint movies_pk
      primary key,
  title varchar(31) not null,
  description varchar(255)
);

alter table movies owner to postgres;

create unique index movies_title_uindex
  on movies (title);

create table hall
(
  id serial not null
    constraint hall_pk
      primary key,
  hall_name varchar(255) not null,
  rows_quant integer not null,
  seats_in_row integer not null
);

alter table hall owner to postgres;

create table seats
(
  id serial not null
    constraint seats_pk
      primary key,
  row integer not null,
  number integer not null,
  hall_id integer
    constraint seats_hall_id_fk
      references hall
      on delete cascade
);

alter table seats owner to postgres;

create table movie_sessions
(
  id serial not null
    constraint movie_sessions_pk
      primary key,
  date date not null,
  time time not null,
  movie_id integer
    constraint movie_sessions_movie_id_fk
      references movies
      on delete cascade,
  hall_id integer
    constraint movie_sessions_hall_id_fk
      references hall
);

alter table movie_sessions owner to postgres;

create table price_categories
(
  id serial not null
    constraint price_categories_pk
      primary key,
  cat_type varchar(31) not null,
  price integer not null
);

alter table price_categories owner to postgres;

create unique index price_categories_cat_type_uindex
  on price_categories (cat_type);

create table orders
(
  id serial not null
    constraint orders_pk
      primary key,
  price_cat_id integer not null
    constraint orders_price_cat_id_fk
      references price_categories,
  user_id integer
    constraint orders_user_id_fk
      references users
      on delete cascade,
  session_id integer not null
    constraint orders_session_id_fk
      references movie_sessions,
  seat_id integer not null
    constraint orders_seat_id_fk
      references seats
);

alter table orders owner to postgres;
