create table doctor (
id bigint primary key,
name varchar(128),
surname varchar(128),
phone_number varchar(128),
address varchar(128),
email varchar(128),
avatar varchar(128),
profession varchar(128)
);
create sequence doctor_id_generator;