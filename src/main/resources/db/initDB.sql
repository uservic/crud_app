drop table if exists dictionary;
drop table if exists user;

create table user
(
	user_id int auto_increment
		primary key,
	role varchar(30) not null
);

create table dictionary
(
	id int auto_increment
		primary key,
	discriminator varchar(30) not null,
	name varchar(255) not null,
	ext_id int not null
);