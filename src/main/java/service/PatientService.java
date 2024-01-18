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
        String username = getUniqueUsername("");
        String password = getValidPassword();

        int result = patientRepository.save(new Patient(name, nationalId, username, password));
        if (result!=0)
            System.out.println("successfull-Patient is added");
        else
            System.out.println("Error-Patient is not added");
    }
    public void editPatient (int patientId) throws SQLException {
        Patient patient = patientRepository.load(patientId);
        if (patient == null){
            System.out.println("nothing exist");
            return;
        }
        System.out.println("You are going to edit this patient : ");
        System.out.println(patient);
        System.out.println("**** edit patient ****");
        System.out.println("Enter new name :");
        String newName = scanner.nextLine();
        String newNationalId = getValidNationalId();
        String newUsername = getUniqueUsername(patient.getUsername());
        String newPassword = getValidPassword();

        int result = patientRepository.edit(new Patient(patientId , newName , newNationalId ,
                newUsername , newPassword));
        if (result != 0)
            System.out.println("Successful");
        else
            System.out.println("Error");
    }

    private String getValidPassword() {
        String password = "" ;
        while (true){
            System.out.println("Enter password : ");
            password = scanner.nextLine();
            if (Validation.isPasswordValid(password))
                break;
            else
                System.out.println("invalid password");
        }
        return password;
    }

    private String getUniqueUsername(String oldUsername) throws SQLException {
        String username = "" ;
        while (true){
            System.out.println("Enter username : ");
            username = scanner.nextLine();
            if (!oldUsername.equals("") && oldUsername.equals(username))
                return username;
            if (!patientRepository.isUsernameExist(username))
                break;
            else
                System.out.println("Username is no available");
        }
        return username;
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
