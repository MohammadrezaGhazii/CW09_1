package entities;

import java.math.BigDecimal;

public class Prescription {
    private int id;
    private int patientId;
    private String medicine;
    private int number;
    private boolean doesExist;
    private BigDecimal price;
}
