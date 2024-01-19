package repository;

import entities.Prescription;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public Prescription load(int prescriptionId) throws SQLException {
        String load = "select * from prescription  where prescription_id=?;";
        PreparedStatement ps = connection.prepareStatement(load);
        ps.setInt(1, prescriptionId);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next())
            return getPrescription(resultSet);
        else {
            System.out.println("prescription with id \'" + prescriptionId + "\' does not exist.");
            return null;
        }
    }

    public Prescription[] loadByPatientId(int patientId) throws SQLException {
        String load = "select * from prescription  where patient_id=?;";
        PreparedStatement ps = connection.prepareStatement(load,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ps.setInt(1, patientId);
        ResultSet resultSet = ps.executeQuery();

        int counter = 0;
        while (resultSet.next()) counter++;
        Prescription[] prescriptions = new Prescription[counter];

        resultSet.beforeFirst();
        int k = 0;
        while (resultSet.next()) {
            prescriptions[k++] = getPrescription(resultSet);
        }
        return prescriptions;
    }

    private static Prescription getPrescription(ResultSet resultSet) throws SQLException {
        Prescription prescription = null;
        int prescription_id = resultSet.getInt(1);
        int patient_id = resultSet.getInt(2);
        String medicine = resultSet.getString(3);
        int number = resultSet.getInt(4);
        String description = resultSet.getString(5);
        boolean doesExist = resultSet.getBoolean(6);
        BigDecimal price = resultSet.getBigDecimal(7);
        boolean adminConfirm = resultSet.getBoolean(8);

        prescription = new Prescription(prescription_id, patient_id, medicine, number
                , description, doesExist, price, adminConfirm);
        return prescription;
    }
}
