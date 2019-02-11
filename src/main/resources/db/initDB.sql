-- drop table if exists user;
drop table if exists users;
drop table if exists dictionary;
drop table if exists dt_seq_gen;

-- create table dictionary
-- (
-- 	id int auto_increment
-- 		primary key,
-- 	discriminator varchar(30) not null,
-- 	name varchar(255) not null,
-- 	ext_id int not null
-- );

create table dictionary
(
	id serial
		constraint dictionary_pk
			primary key,
	discriminator varchar(30) not null,
	name varchar(255) not null,
	ext_id int not null
);

-- create table user
-- (
-- 	id int auto_increment
-- 		primary key,
-- 	login varchar(31) not null,
-- 	password varchar(255) not null,
-- 	role int null,
-- 	constraint user_login_uindex
-- 		unique (login),
-- 	constraint user_role_fk
-- 		foreign key (role) references dictionary (id)
-- 			on delete set null
-- );

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

-- create table dt_seq_gen
-- (
-- 	name varchar(255) not null,
-- 	counter int not null,
-- 	constraint `dict-types-seq-gen_name_uindex`
-- 		unique (name)
-- );
--
-- alter table dt_seq_gen
-- 	add primary key (name);

create table dt_seq_gen
(
	name varchar(255)
		constraint dt_seq_gen_pk
			primary key,
	counter int not null
);