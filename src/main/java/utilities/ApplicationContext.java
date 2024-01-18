package utilities;

import connection.JdbcConnection;
import repository.PatientRepository;
import service.PatientService;

import java.sql.Connection;

public class ApplicationContext {
    private static final Connection CONNECTION ;
    private static final PatientRepository PATIENT_REPOSITORY ;
    private static final PatientService PATIENT_SERVICE ;
    static {
        CONNECTION = JdbcConnection.getConnection();
        PATIENT_REPOSITORY = new PatientRepository(CONNECTION);
        PATIENT_SERVICE = new PatientService(PATIENT_REPOSITORY);
    }
    public static PatientService getPatientService(){
        return PATIENT_SERVICE ;
    }
}
