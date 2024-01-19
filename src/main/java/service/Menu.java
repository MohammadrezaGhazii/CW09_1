package service;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    public void menu (){
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
    public void signMenu (String user){
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
                        case "Admin" -> System.out.println("admin sign up");
                        case "Patient" -> System.out.println("Patient sign up");
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
