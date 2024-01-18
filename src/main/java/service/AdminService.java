package service;

import entities.Admin;
import repository.AdminRepository;
import utilities.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminService {
    private final AdminRepository adminRepository;
    private final Scanner scanner=new Scanner(System.in);

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    public void addAdmin() throws SQLException {
        System.out.println("***register admin***");
        System.out.println("enter admin name: ");
        String name = scanner.nextLine();
        String username=getUniqueUsername();
        String password=getStrongPassword();
        int result = adminRepository.save(new Admin(name, username, password));
        if (result!=0){
            System.out.println("successful");
        }
        else
            System.out.println("error");



    }

    private String getStrongPassword() {
        String password="";
        while (true){
            System.out.println("enter admin password");
            password=scanner.nextLine();
            if (Validation.isPasswordValid(password))
                break;
            else
                System.out.println("invalid Password");
        }
        return password;
    }

    private String getUniqueUsername() throws SQLException {
        String username="";
        while (true){
            System.out.println("enter admin username: ");
            username = scanner.nextLine();
            if (!adminRepository.isUsernameExists(username)){
                break;
            }
            else
                System.out.println("username is not available");
        }
        return username;
    }
}
