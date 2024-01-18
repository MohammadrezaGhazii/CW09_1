CREATE TABLE IF NOT EXISTS patient
(
    patient_id SERIAL PRIMARY KEY ,
    name VARCHAR(50),
    national_id VARCHAR(50) UNIQUE ,
    username VARCHAR(50) UNIQUE ,
    password VARCHAR(50)
);
CREATE TABLE IF NOT EXISTS admin
(
    admin_id SERIAL PRIMARY KEY ,
    name VARCHAR (50),
    username VARCHAR (50) UNIQUE ,
    password VARCHAR (50)
);
CREATE TABLE IF NOT EXISTS prescription
(
    prescription_id SERIAL PRIMARY KEY ,
    patient_id int references patient(patient_id),
    medicine VARCHAR(50),
    number int ,
    description VARCHAR(255),
    does_exist boolean ,
    price BIGINT ,
    admin_confirm boolean
);