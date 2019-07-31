use java;
-- 创建表
create table user(
id int primary key auto_increment,
username varchar(32) unique not null ,
password varchar (72) not null
)

show tables;

insert into user (id, username, password) value(
null ,"lxgzhw",'lxgzhw'
)

--查看是否插入成功
select username,password from user where id=1;

select *from user where username='lxgzhw' and password='lxgzhw';