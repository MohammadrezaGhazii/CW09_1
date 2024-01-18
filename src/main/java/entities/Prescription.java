package entities;

import java.math.BigDecimal;
import java.util.Objects;

public class Prescription {
    private int id;
    private int patientId;
    private String medicine;
    private int number;
    private boolean doesExist;
    private BigDecimal price;

    public Prescription() {
    }

    public Prescription(int patientId, String medicine, int number, boolean doesExist, BigDecimal price) {
        this.patientId = patientId;
        this.medicine = medicine;
        this.number = number;
        this.doesExist = doesExist;
        this.price = price;
    }

    public Prescription(int id, int patientId, String medicine, int number, boolean doesExist, BigDecimal price) {
        this.id = id;
        this.patientId = patientId;
        this.medicine = medicine;
        this.number = number;
        this.doesExist = doesExist;
        this.price = price;
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

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", medicine='" + medicine + '\'' +
                ", number=" + number +
                ", doesExist=" + doesExist +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription that = (Prescription) o;
        return id == that.id && patientId == that.patientId && number == that.number && doesExist == that.doesExist && Objects.equals(medicine, that.medicine) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientId, medicine, number, doesExist, price);
    }
}
