package entities;

import java.math.BigDecimal;
import java.util.Objects;

public class Prescription {
    private int id;
    private int patientId;
    private String medicine;
    private int number;
    private String description ;
    private boolean doesExist;
    private BigDecimal price;
    private boolean adminConfirm ;

    public Prescription() {
    }

    public Prescription(int id, int patientId, String medicine, int number, String description, boolean doesExist, BigDecimal price, boolean adminConfirm) {
        this.id = id;
        this.patientId = patientId;
        this.medicine = medicine;
        this.number = number;
        this.description = description;
        this.doesExist = doesExist;
        this.price = price;
        this.adminConfirm = adminConfirm;
    }

    public Prescription(int patientId, String medicine, int number, String description, boolean doesExist, BigDecimal price, boolean adminConfirm) {
        this.patientId = patientId;
        this.medicine = medicine;
        this.number = number;
        this.description = description;
        this.doesExist = doesExist;
        this.price = price;
        this.adminConfirm = adminConfirm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDoesExist() {
        return doesExist;
    }

    public void setDoesExist(boolean doesExist) {
        this.doesExist = doesExist;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAdminConfirm() {
        return adminConfirm;
    }

    public void setAdminConfirm(boolean adminConfirm) {
        this.adminConfirm = adminConfirm;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", medicine='" + medicine + '\'' +
                ", number=" + number +
                ", description='" + description + '\'' +
                ", doesExist=" + doesExist +
                ", price=" + price +
                ", adminConfirm=" + adminConfirm +
                '}';
    }
}
