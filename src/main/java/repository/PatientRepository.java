package repository;

import entities.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientRepository {
    private final Connection connection ;

    public PatientRepository(Connection connection) {
        this.connection = connection;
    }

    public int save (Patient patient) throws SQLException {
        String saveQuery = "INSERT INTO patient (name, national_id, username, password) " +
                "VALUES (?,?,?,?);" ;
        PreparedStatement ps = connection.prepareStatement(saveQuery);
        ps.setString(1, patient.getPatientName());
        ps.setString(2,patient.getNationalId());
        ps.setString(3,patient.getUsername());
        ps.setString(4,patient.getPassword());

        return ps.executeUpdate();
    }
    public boolean isUsernameExist (String username) throws SQLException {
        String exist = "SELECT * FROM patient WHERE username = ? ;" ;
        PreparedStatement ps = connection.prepareStatement(exist);
        ps.setString(1,username);

        ResultSet resultSet = ps.executeQuery();
        return resultSet.next();
    }
}
