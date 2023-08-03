package model.enums;

public enum ScreenSize {
    SMALL( 150 ), MIDDLE( 250 ), LARGE( 350 );

    private final int maxSize;

    ScreenSize ( int maxSize ) {
        this.maxSize = maxSize;
    }

    public int getMaxCapacity ( ) {
        return maxSize;
    }
}
