package entities;

import java.util.Arrays;
import java.util.Objects;

public class Patient {
    private int patientID ;
    private String patientName ;
    private String nationalId ;
    private String username ;
    private String password ;
    private Prescription [] prescription ;

    public Patient() {
    }

    public Patient(String patientName, String nationalId, String username, String password) {
        this.patientName = patientName;
        this.nationalId = nationalId;
        this.username = username;
        this.password = password;
    }

    public Patient(int patientID, String patientName, String nationalId, String username, String password, Prescription[] prescription) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.nationalId = nationalId;
        this.username = username;
        this.password = password;
        this.prescription = prescription;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Prescription[] getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription[] prescription) {
        this.prescription = prescription;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientID=" + patientID +
                ", patientName='" + patientName + '\'' +
                ", nationalId='" + nationalId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", prescription=" + Arrays.toString(prescription) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return patientID == patient.patientID && Objects.equals(patientName, patient.patientName) && Objects.equals(nationalId, patient.nationalId) && Objects.equals(username, patient.username) && Objects.equals(password, patient.password) && Arrays.equals(prescription, patient.prescription);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(patientID, patientName, nationalId, username, password);
        result = 31 * result + Arrays.hashCode(prescription);
        return result;
    }
}
