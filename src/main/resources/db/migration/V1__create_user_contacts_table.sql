create table if not exists contacts(
id bigint not null auto_increment primary key,
name varchar(60),
phone varchar(60)
);