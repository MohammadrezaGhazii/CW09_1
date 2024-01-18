package service;

import repository.PatientRepository;

public class PatientService {
    private final PatientRepository patientRepository ;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
}
