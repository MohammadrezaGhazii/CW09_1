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
}
