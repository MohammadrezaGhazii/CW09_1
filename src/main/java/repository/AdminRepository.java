package repository;

import java.sql.Connection;

public class AdminRepository {
    private final Connection connection;


    public AdminRepository(Connection connection) {
        this.connection = connection;
    }
}
