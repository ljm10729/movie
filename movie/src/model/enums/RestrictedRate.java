package model.enums;

public enum RestrictedRate {
    ALL(0), TWELVE(12), FIFTEEN(15), R_RATED(18);

    private final Integer restrictedAge;

    RestrictedRate ( int age ) {
        this.restrictedAge = age;
    }

    public Integer getRestrictedAge ( ) {
        return restrictedAge;
    }
}
