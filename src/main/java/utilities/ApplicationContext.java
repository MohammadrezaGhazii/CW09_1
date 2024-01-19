package utilities;

import connection.JdbcConnection;
import repository.AdminRepository;
import repository.PatientRepository;
import service.AdminService;
import service.PatientService;

import java.sql.Connection;

public class ApplicationContext {
    private static final Connection CONNECTION ;
    private static final PatientRepository PATIENT_REPOSITORY ;
    private static final PatientService PATIENT_SERVICE ;
    private static final AdminRepository ADMIN_REPOSITORY;
    private static final AdminService ADMIN_SERVICE;

    static {
        CONNECTION = JdbcConnection.getConnection();
        PATIENT_REPOSITORY = new PatientRepository(CONNECTION);
        PATIENT_SERVICE = new PatientService(PATIENT_REPOSITORY);

        ADMIN_REPOSITORY=new AdminRepository(CONNECTION);
        ADMIN_SERVICE=new AdminService(ADMIN_REPOSITORY);
    }
    public static PatientService getPatientService(){
        return PATIENT_SERVICE ;
    }
    public static AdminService getAdminService(){
        return ADMIN_SERVICE;
    }
}
