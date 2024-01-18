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
    public Patient load (int patientId) throws SQLException {
        String loadQuary = "SELECT * FROM patient WHERE patient_id = ?;";
        PreparedStatement ps = connection.prepareStatement(loadQuary);
        ps.setInt(1,patientId);

        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()){
            int patient_id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String national_id = resultSet.getString(3);
            String user_name = resultSet.getString(4);
            String password = resultSet.getString(5);

            return new Patient(patient_id , name , national_id , user_name , password );
        }
        else {
            System.out.println("patient with id \' " + patientId + "\' is not exist");
            return null ;
        }
    }
    public int edit (Patient patient) throws SQLException {
        String editQuery = "UPDATE patient SET name = ?, national_id = ?," +
                " username = ?, password = ? WHERE patient_id = ? ;" ;
        PreparedStatement ps = connection.prepareStatement(editQuery);
        ps.setString(1, patient.getPatientName());
        ps.setString(2,patient.getNationalId());
        ps.setString(3,patient.getUsername());
        ps.setString(4,patient.getPassword());
        ps.setInt(5,patient.getPatientID());

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
