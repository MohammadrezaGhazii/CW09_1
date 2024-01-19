import service.AdminService;
import service.PatientService;
import service.PrescriptionService;
import utilities.ApplicationContext;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//        PatientService patientService = ApplicationContext.getPatientService();
//        System.out.println("Enter id : ");
//        int id = scanner.nextInt();
//        patientService.deletePatient(id);
//        AdminService adminService=ApplicationContext.getAdminService();
//        adminService.addAdmin();
//        PrescriptionService prescriptionService=ApplicationContext.getPrescriptionService();
//        prescriptionService.addPrescription(1);

//        PatientService patientService=ApplicationContext.getPatientService();
//        patientService.addPatient();
        PrescriptionService prescriptionService=ApplicationContext.getPrescriptionService();
//        prescriptionService.confirmByAdmin(1);
        prescriptionService.adminConfirmByPatientId(1);
    }
}
