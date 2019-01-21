drop table if exists user;
drop table if exists dictionary;

create table dictionary
(
	id int auto_increment
		primary key,
	discriminator varchar(30) not null,
	name varchar(255) not null,
	ext_id int not null
);

create table user
(
	id int auto_increment
		primary key,
	login varchar(31) not null,
	password varchar(255) not null,
	role int null,
	constraint user_login_uindex
		unique (login),
	constraint user_role_fk
		foreign key (role) references dictionary (id)
			on delete set null
);