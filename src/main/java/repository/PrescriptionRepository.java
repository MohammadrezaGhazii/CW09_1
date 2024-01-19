package repository;

import java.sql.Connection;

public class PrescriptionRepository {
    private final Connection connection;

    public PrescriptionRepository(Connection connection) {
        this.connection = connection;
    }
}
