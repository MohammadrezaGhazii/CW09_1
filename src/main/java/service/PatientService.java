package service;

import entities.Patient;
import repository.PatientRepository;
import utilities.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class PatientService {
    private final PatientRepository patientRepository ;
    private final Scanner scanner = new Scanner(System.in);

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void addPatient () throws SQLException {
        System.out.println("****** patient info ******");
        System.out.println("Enter name : ");
        String name = scanner.nextLine();
        String nationalId = getValidNationalId();
        System.out.println("Enter username : ");
        String username = scanner.nextLine();
        System.out.println("Enter password : ");
        String password = scanner.nextLine();

        int result = patientRepository.save(new Patient(name, nationalId, username, password));
        if (result!=0)
            System.out.println("successfull-Patient is added");
        else
            System.out.println("Error-Patient is not added");
    }

    private String getValidNationalId() {
        String nationalId = "" ;
        while (true) {
            System.out.println("Enter national id : ");
            nationalId = scanner.nextLine();
            if (Validation.validateMelliCode(nationalId))
                return nationalId;
            else
                System.out.println("invalid national id");
        }
    }
}
