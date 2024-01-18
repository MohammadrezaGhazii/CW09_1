package repository;

import entities.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
