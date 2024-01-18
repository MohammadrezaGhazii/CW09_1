package entities;

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
}
