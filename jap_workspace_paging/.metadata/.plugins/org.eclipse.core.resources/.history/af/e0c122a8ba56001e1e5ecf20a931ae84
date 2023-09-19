--board table--
create board (
bno int NOT NULL AUTO_INCREMENT,
title varchar(200) NOT NULL,
writer varchar(100) NOT NULL,
content text,
regdate datetime DEFAULT CURRENT_TIMESTAMP,
moddate datetime DEFAULT CURRENT_TIMESTAMP,
primary key (bno));

--member table--
create table mamber(
id varchar(100),
pwd varchar(100) not null,
email varchar(100) not null,
age int default 0,
regdate datetime default now(),
lastlogin datetime default now(),
primary key(id));

--comment table--
create table comment(
cno int auto_increment,
bno int not null,
writer varchar(200) not null default "unknown",
content varchar(1000),
regdate datetime default now(),
primary key(cno));