create table patient (
    id bigint primary key,
    opd bigint,
    idp bigint,
    name varchar(128),
    surname varchar(128),
    phone_number bigint,
    address varchar(128),
    email varchar(128),
    avatar varchar(128),
    blood_group varchar(128),
    notes varchar(128),
    chronic_patient boolean,
    last_admission timestamp,
    last_doctor_visited_id bigint references doctor (id)
);
create sequence patient_id_generator;
