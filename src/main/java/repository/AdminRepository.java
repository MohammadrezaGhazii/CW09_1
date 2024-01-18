package repository;

import entities.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminRepository {
    private final Connection connection;


    public AdminRepository(Connection connection) {
        this.connection = connection;
    }
    public int save(Admin admin) throws SQLException {
        String saveQuery="INSERT INTO admin(name, username, password) VALUES(?,?,?);";
        PreparedStatement ps=connection.prepareStatement(saveQuery);
        ps.setString(1, admin.getName());
        ps.setString(2,admin.getUsername());
        ps.setString(3,admin.getPassword());

        return ps.executeUpdate();
    }
}
