package repository;

import entities.Prescription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrescriptionRepository {
    private final Connection connection;

    public PrescriptionRepository(Connection connection) {
        this.connection = connection;
    }

    public int save(Prescription prescription) throws SQLException {
        String save = "insert into prescription(patient_id, medicine, number, description, does_exist, price, admin_confirm)" +
                "values (?,?,?,?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(save);
        ps.setInt(1, prescription.getPatientId());
        ps.setString(2, prescription.getMedicine());
        ps.setInt(3, prescription.getNumber());
        ps.setString(4, prescription.getDescription());
        ps.setBoolean(5, prescription.isDoesExist());
        ps.setBigDecimal(6, prescription.getPrice());
        ps.setBoolean(7, prescription.isAdminConfirm());

        return ps.executeUpdate();

    }

    public int edit(Prescription prescription) throws SQLException {
        String edit = "UPDATE prescription set medicine=?,number=?,description=?,does_exist=?,price=?,admin_confirm=? " +
                "                    where patient_id=? and prescription_id=?;";
        PreparedStatement ps = connection.prepareStatement(edit);
        ps.setString(1, prescription.getMedicine());
        ps.setInt(2, prescription.getNumber());
        ps.setString(3, prescription.getDescription());
        ps.setBoolean(4, prescription.isDoesExist());
        ps.setBigDecimal(5, prescription.getPrice());
        ps.setBoolean(6, prescription.isAdminConfirm());
        ps.setInt(7, prescription.getPatientId());
        ps.setInt(8, prescription.getId());

        return ps.executeUpdate();
    }
}
