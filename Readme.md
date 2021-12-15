This is a simple work using Spring-MVC+MyBatis+MySQL+Maven.
1.With the use of annotations like @Component @Service @Repository @Controller, the classes become singleton.

2.The injection of 'sqlSessionFactory' makes it easier to load 'mybatis-config.xml', and 'sqlSessionFactory' also becomes a singleton.

All the Dao named 'XXXMapper' should be placed in mapper package, because a 'MapperScannerConfigurer' has been defined in the 'mvc-dispatcher-servlet.xml' file to scan all the mappers.


Table user:
create table user (userId int auto_increment, username varchar(32), password varchar(32), isManager boolean not null, primary key(userId));
Data:
insert into user values(null,'admin','123456',true);
insert into user values(null,'mary','123456',false);
insert into user values(null,'kate','123456',false);
insert into user values(null,'tom','123456',false);

Table catalog:
create table catalog
(catalog_id int auto_increment,
catalog_name varchar(32),
primary key(catalog_id));
Data:
insert into catalog values(null,'STARTER');
insert into catalog values(null,'MAIN COURSE');
insert into catalog values(null,'SWEET');
insert into catalog values(null,'SIDES');
insert into catalog values(null,'MINERALS');
insert into catalog values(null,'DRAUGHT');
Table food:
create table food (
food_id int auto_increment,
catalog_id int not null,
food_name varchar(50),
food_price double,
primary key(food_id));

Data:
Insert into food values(null,1,'soup of the day',3.95);
Insert into food values(null,1,'bread',3.95);
Insert into food values(null,2,'rump steak',12.95);
Insert into food values(null,2,'cheeseburger',9.95);
Insert into food values(null,3,'chocolate cheesecake',3.95);
Insert into food values(null,3,'ice cream',4.95);
Insert into food values(null,4,'chips',2.95);
Insert into food values(null,4,'rocket salad',2.95);
Insert into food values(null,5,'lager',3.95);
Insert into food values(null,5,'mild',3.95);
Insert into food values(null,6,'coke',2.95);
Insert into food values(null,6,'diet coke',2.95);
Table orders:
create table orders(d
o_id int not null auto_increment,
order_id varchar(32) not null,
table_id int not null,
food_id int not null,
quantity int not null,
order_status int not null,
note varchar(50),
primary key(o_id)
);
Data:
insert into orders values(null,'202112110001',2,3,1,0,'medium please');
insert into orders values(null,'202112110001',2,7,1,0,null);

Table Order_seq:
create table order_seq (
timestr int, order_sn int
);
Function:
delimiter //
create function order_seq()
returns varchar(50)

begin
declare time_tmp integer;
declare current_value integer;
declare value_tmp varchar(50);
declare rowcount BIGINT;

set time_tmp = date_format(now(),'%Y%m%d');
set current_value=1;

select order_sn+1 into current_value from order_seq where timestr=time_tmp;
update order_seq set order_sn = current_value where timestr=time_tmp;

if row_count()=0 then
insert into order_seq values(time_tmp,current_value);
end if;

select concat(time_tmp,LPAD(order_sn,4,0)) into value_tmp from order_seq where timestr=time_tmp;
return value_tmp;
end;
//
delimiter ;
How to use: select order_seq();