package utilities;

import connection.JdbcConnection;
import repository.AdminRepository;
import repository.PatientRepository;
import repository.PrescriptionRepository;
import service.AdminService;
import service.PatientService;
import service.PrescriptionService;

import java.sql.Connection;

public class ApplicationContext {
    private static final Connection CONNECTION ;
    private static final PatientRepository PATIENT_REPOSITORY ;
    private static final PatientService PATIENT_SERVICE ;
    private static final AdminRepository ADMIN_REPOSITORY;
    private static final AdminService ADMIN_SERVICE;
    private static final PrescriptionRepository PRESCRIPTION_REPOSITORY;
    private static final PrescriptionService PRESCRIPTION_SERVICE;

    static {
        CONNECTION = JdbcConnection.getConnection();
        PATIENT_REPOSITORY = new PatientRepository(CONNECTION);
        PATIENT_SERVICE = new PatientService(PATIENT_REPOSITORY);

        ADMIN_REPOSITORY=new AdminRepository(CONNECTION);
        ADMIN_SERVICE=new AdminService(ADMIN_REPOSITORY);

        PRESCRIPTION_REPOSITORY=new PrescriptionRepository(CONNECTION);
        PRESCRIPTION_SERVICE=new PrescriptionService(PRESCRIPTION_REPOSITORY);
    }
    public static PatientService getPatientService(){
        return PATIENT_SERVICE ;
    }
    public static AdminService getAdminService(){
        return ADMIN_SERVICE;
    }
    public static PrescriptionService getPrescriptionService(){
        return PRESCRIPTION_SERVICE;
    }
}
