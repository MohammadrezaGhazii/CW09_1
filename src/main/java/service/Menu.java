package service;

import utilities.ApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final AdminService adminService = ApplicationContext.getAdminService();
    private final PatientService patientService = ApplicationContext.getPatientService();
    public void menu () throws SQLException {
        int choice = -1 ;
        while (choice != 0){
            System.out.println("*** Main menu ***");
            System.out.println("1-Admin");
            System.out.println("2-Patient");
            System.out.println("0-Exit");

            System.out.println("Choose a number : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 -> signMenu("Admin");
                case 2 -> signMenu("Patient");
                case 0 -> {
                    System.out.println("Bye Bye");
                    break;
                }
            }
        }
    }
    public void signMenu (String user) throws SQLException {
        int choice = -1 ;

        while (choice != 0){
            System.out.println("*** Sign " + user + " ***");
            System.out.println("1-Sign up");
            System.out.println("2-Sign in");
            System.out.println("0-Exit");

            System.out.println("Choose a number : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 -> {
                    switch (user){
                        case "Admin" -> adminService.addAdmin();
                        case "Patient" -> patientService.addPatient();
                    }
                }
                case 2 -> {
                    switch (user) {
                        case "Admin" -> System.out.println("admin sign in");
                        case "Patient" -> System.out.println("Patient sign in");
                    }
                }
                case 0 -> {
                    System.out.println("Bye Bye");
                    break;
                }
            }
        }
    }
}
