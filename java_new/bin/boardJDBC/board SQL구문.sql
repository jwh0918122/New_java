create table board(
bno int auto_increment,
title varchar(200) not null,
writer varchar(100) not null,
content text,
regdate datetime default now(), 
moddate datetime default now(),
readcount int default 0,
primary key(bno));