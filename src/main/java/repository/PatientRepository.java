package repository;

import java.sql.Connection;

public class PatientRepository {
    private final Connection connection ;

    public PatientRepository(Connection connection) {
        this.connection = connection;
    }
}
