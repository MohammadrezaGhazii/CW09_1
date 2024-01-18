package service;

import repository.AdminRepository;

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
        getUniqueUsername();


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
