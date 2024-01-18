package service;

import repository.PatientRepository;
import utilities.Validation;

import java.util.Scanner;

public class PatientService {
    private final PatientRepository patientRepository ;
    private final Scanner scanner = new Scanner(System.in);

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void addPatient (){
        System.out.println("****** patient info ******");
        System.out.println("Enter name : ");
        String name = scanner.nextLine();
        String nationalId = getValidNationalId();
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
