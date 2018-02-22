create table game(
game_no int not null auto_increment,
description text null,
title varchar(150) not null,
cover_image varchar(150) null,
state varchar(3) not null,
file_name varchar(150)
PRIMARY KEY (game_no) ) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table user(
user_no int not null auto_increment,
email varchar(100) not null,
password varchar(60) not null,
nickname varchar(50) not null,
birthday date null,
join_date date not null,
PRIMARY KEY (user_no)) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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