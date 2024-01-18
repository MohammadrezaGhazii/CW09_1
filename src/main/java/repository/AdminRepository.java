package repository;

import entities.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public boolean isUsernameExists(String username) throws SQLException {
        String exists="SELECT * FROM admin WHERE username=?;";
        PreparedStatement ps=connection.prepareStatement(exists);
        ps.setString(1,username);

        ResultSet resultSet = ps.executeQuery();

       return resultSet.next();


    }
}
