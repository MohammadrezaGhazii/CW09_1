package service;

import repository.PrescriptionRepository;

public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;


    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }
}
