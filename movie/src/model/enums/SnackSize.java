package model.enums;

public enum SnackSize {
    TALL( 1.0 ), GRANDE( 1.2 ), BENTI( 1.4 );

    private final Double multipleRate;

    SnackSize ( Double multipleRate ) {
        this.multipleRate = multipleRate;
    }

    public Double getMultipleRate ( ) {
        return multipleRate;
    }
}
