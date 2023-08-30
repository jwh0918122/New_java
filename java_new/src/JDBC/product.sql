-- 2023-08-30

create table product(
pno int not null auto_increment,
pname varchar(100) not null,
price int not null default 0,
regdate datetime default now(),
madeby text,
primary key(pno)
);