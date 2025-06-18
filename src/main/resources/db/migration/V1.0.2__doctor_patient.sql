create table doctor_patient (
    doctor_id bigint not null references doctor(id),
    patient_id bigint not null references patient(id)
);