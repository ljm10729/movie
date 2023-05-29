package service;

public class Discount {

    // 할인 종류
    private String type;
    // 할인율
    private Double rate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
