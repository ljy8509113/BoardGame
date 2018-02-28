drop table authority;
drop table users_authority;
drop table game;
drop table user;

desc game;
desc user;
desc authority;
desc users_authority;

select * from game;
select * from user;
select * from authority;
select * from users_authority;

create table game(
game_no int not null auto_increment,
description text null,
title varchar(150) not null,
cover_image varchar(150) null,
state varchar(3) not null,
file_name varchar(150),
version varchar(10) null,
PRIMARY KEY (game_no) ) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table user(
user_no int not null auto_increment,
email varchar(100) not null,
password varchar(60) not null,
nickname varchar(50) not null,
birthday date null,
join_date date null,
fail_count int default 0,
PRIMARY KEY (user_no)) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE authority (
	id	INT NOT NULL PRIMARY KEY,
	name VARCHAR(30) NOT NULL
) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE users_authority(
	users_no INT NOT NULL,
	authority_id INT NOT NULL,
	FOREIGN KEY (users_no) REFERENCES user(user_no),
	FOREIGN KEY (authority_id) REFERENCES authority(id)
) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table history(
user_no int not null,  	
total int,		
win int,		
lose int,		
stop int,		
winning_rate float,	
game_no int not null,
PRIMARY KEY (user_no, game_no),
FOREIGN KEY (user_no) REFERENCES user (user_no),
FOREIGN KEY (game_no) REFERENCES game (game_no)) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;		


create table board(
board_no int not null auto_increment,
user_no int not null,
title varchar(150) not null,	
date date not null,	
content	text,
is_active tinyint(1) not null default 1,
count int not null,	
reader text,	
PRIMARY KEY (board_no),
FOREIGN KEY (user_no) REFERENCES user (user_no)) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;		


create table reply(
reply_no int not null auto_increment,
user_no int not null,
date date not null,	
content	varchar(255) not null,
is_active tinyint(1) not null default 1,
board_no int not null,
PRIMARY KEY (reply_no),
FOREIGN KEY (user_no) REFERENCES user (user_no),
FOREIGN KEY (board_no) REFERENCES board (board_no)) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;	

create table sub_reply(
user_no int not null,
date date not null,	
content	varchar(255) not null,
is_active tinyint(1) not null default 1,
reply_no int not null,
PRIMARY KEY (reply_no, user_no),
FOREIGN KEY (reply_no) REFERENCES reply (reply_no)) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;	

create table admin(
no int not null auto_increment,
id varchar(30) not null,
password varchar(200) not null,
name varchar(30) not null,
primary key(no)) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

#게임플레이 관련
create table boardgame.game_room(
no int not null auto_increment,
title varchar(130) not null,
game_no int not null,
full_user int(3) not null,
state varchar(2) not null,
master_uuid varchar(150) not null,
primary key(no),
FOREIGN KEY (game_no) REFERENCES boardgame.game(game_no)) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table boardgame.game_user(
game_room int not null,
user_uuid varchar(150) not null,
master_uuid varchar(150) not null,
FOREIGN KEY (game_room) REFERENCES boardgame.game_room(no)
) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
