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
        scanner.nextLine();
        System.out.println("enter description ");
        String description = scanner.nextLine();

        int resualt = prescriptionRepository.save(new Prescription(patientId,
                medicine,
                number,
                description,
                false,
                new BigDecimal("0"),
                false));
        if (resualt != 0) {
            System.out.println("succesfull");
        } else
            System.out.println("error");
    }

    public void confirmByAdmin(int prescriptionId) throws SQLException {
        Prescription prescription = prescriptionRepository.load(prescriptionId);
        adminConfirmOneByOne(prescription);
    }
    public void adminConfirmByPatientId(int patientId) throws SQLException {
        Prescription[] prescriptions = prescriptionRepository.loadByPatientId(patientId);
        for (Prescription prescription : prescriptions) {
            adminConfirmOneByOne(prescription);
        }
    }

    private void adminConfirmOneByOne(Prescription prescription) throws SQLException {
        System.out.println(" you are goting to confirm prescription");
        System.out.println(prescription);
        System.out.println("do you confirm this prescription ? [y/n]");
        String yn = scanner.nextLine();
        boolean adminConfirm = false;
        if (yn.equals("y")) {
            adminConfirm = true;
        } else return;
        boolean doesExist = false;
        if (adminConfirm) {
            System.out.println("this item does exist ? [y/n]");
            yn = scanner.nextLine();
            if (yn.equals("y")) {
                doesExist = true;
            }
        }
        BigDecimal price = new BigDecimal("0");
        if (doesExist) {
            System.out.println("please enter  price ");
            price = scanner.nextBigDecimal();
        }
        int result = prescriptionRepository.edit(new Prescription(prescription.getId(),
                prescription.getPatientId(),
                prescription.getMedicine(),
                prescription.getNumber(),
                prescription.getDescription(), doesExist, price, adminConfirm));
        if (result != 0){
            System.out.println("succesfull");
        }else
            System.out.println("error");
    }

}
