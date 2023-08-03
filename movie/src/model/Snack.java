package model;

import model.enums.SnackCode;
import model.enums.SnackSize;

public class Snack {
    private final SnackCode snackCode;
    private final String name;
    private final Double basePrice;
    private SnackSize snackSize;

    public Snack ( SnackCode snackCode, String name, Double basePrice, SnackSize snackSize ) {
        this.snackCode = snackCode;
        this.name = name;
        this.basePrice = basePrice;
        this.snackSize = snackSize;
    }

    public Snack ( SnackCode snackCode, String name, Double basePrice ) {
        this.snackCode = snackCode;
        this.name = name;
        this.basePrice = basePrice;
    }

    public SnackCode getSnackCode ( ) {
        return snackCode;
    }

    public String getName ( ) {
        return name;
    }

    public Double getBasePrice ( ) {
        return basePrice;
    }

    public SnackSize getSnackSize ( ) {
        return snackSize;
    }
}
