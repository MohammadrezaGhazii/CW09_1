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

            switch (choice){
                case 1 -> System.out.println("admin");
                case 2 -> System.out.println("Patient");
                case 0 -> {
                    System.out.println("Bye Bye");
                    break;
                }
            }
        }

    }
}
