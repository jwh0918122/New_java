--0920
create table board(
bno int auto_increment,
title varchar(500),
writer varchar(100) not null,
content varchar(1000),
regDate datetime default now(),
modDate datetime default now(),
commentCnt int default 0,
imgFile varchar(500),
primary key(bno));

--0920
create table member(
id varchar(100) not null,
pw varchar(100) not null,
name varchar(50) not null,
age int,
phone varchar(20),
regDate datetime default now(),
lastLogin datetime default now(),
primary key(id));

--0921
alter table member add gender varchar(10) not null;