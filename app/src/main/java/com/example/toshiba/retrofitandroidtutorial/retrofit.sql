create table users (
    id int not null auto_increment,
    email varchar(200) not null,
    password text not null,
    name varchar(500) not null,
    school varchar(1000) not null,
    constraint users_pk primary key(id)
);