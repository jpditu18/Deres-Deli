package com.pluralsight.types;

public enum Size {
    FOUR(4, 5.50, 1.00, 0.75),
    EIGHT(8, 7.00, 2.00, 1.50),
    TWELVE(12, 8.50, 3.00, 2.25);

    private final int inches;
    private final double basePrice, meatPrice, cheesePrice;

    Size(int inches, double basePrice, double meatPrice, double cheesePrice) {
        this.inches = inches;
        this.basePrice = basePrice;
        this.meatPrice = meatPrice;
        this.cheesePrice = cheesePrice;
    }

    public int getInches() { return inches; }
    public double getBasePrice() { return basePrice; }
    public double getMeatPrice() { return meatPrice; }
    public double getCheesePrice() { return cheesePrice; }

    public static Size fromInt(int i) {
        return switch (i) {
            case 4 -> FOUR;
            case 8 -> EIGHT;
            case 12 -> TWELVE;
            default -> null;
        };
    }
}
