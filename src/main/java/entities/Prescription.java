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

}
