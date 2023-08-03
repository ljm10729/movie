package model.enums;

public enum DiscountType {
    CARD(0.1, 0),
    MOBILE(0.05, 0),
    EVENT_A(0.0, 10000),
    EVENT_B(0.0, 0);

    private final Double rate;
    private final Integer amount;

    DiscountType ( Double rate, Integer amount ) {
        this.rate = rate;
        this.amount = amount;
    }

    public Double getRate ( ) {
        return rate;
    }

    public Integer getAmount ( ) {
        return amount;
    }
}
