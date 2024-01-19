package service;

import entities.Prescription;
import repository.PrescriptionRepository;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;
    private final Scanner scanner = new Scanner(System.in);

    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public void addPrescription(int patientId) throws SQLException {

        System.out.println("****** add prescription ******");
        System.out.println("enter medicine ");
        String medicine = scanner.nextLine();
        System.out.println("enter number ");
        int number = scanner.nextInt();
        System.out.println("enter description ");
        String description = scanner.nextLine();

       int resualt= prescriptionRepository.save(new Prescription(patientId,
                medicine,
                number,
                description,
                false,
                new BigDecimal("0"),
                false));
    if (resualt !=0)
    {
        System.out.println("succesfull");
    }else
        System.out.println("error");
    }
}
