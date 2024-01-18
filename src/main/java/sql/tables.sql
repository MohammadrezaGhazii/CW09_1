CREATE TABLE IF NOT EXISTS patient
(
    patient_id SERIAL PRIMARY KEY ,
    name VARCHAR(50),
    national_id VARCHAR(50) UNIQUE ,
    username VARCHAR(50) UNIQUE ,
    password VARCHAR(50)
);