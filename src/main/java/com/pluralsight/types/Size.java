package com.pluralsight.types;

public enum Size {
    FOUR(4, 5.50, 1.00,.50 , 0.75,0.30 ),
    EIGHT(8, 7.00, 2.00,1.00 , 1.50, 0.60),
    TWELVE(12, 8.50, 3.00, 1.50, 2.25, 0.90);

    private final int inches;
    private final double basePrice, meatPrice, extraMeatPrice, cheesePrice, extraCheesePrice;

    Size(int inches, double basePrice, double meatPrice, double extraMeatPrice, double cheesePrice, double extraCheesePrice) {
        this.inches = inches;
        this.basePrice = basePrice;
        this.meatPrice = meatPrice;
        this.extraMeatPrice = extraMeatPrice;
        this.cheesePrice = cheesePrice;
        this.extraCheesePrice = extraCheesePrice;
    }

    public int getInches() { return inches; }
    public double getBasePrice() {
        return basePrice;
    }
    public double getMeatPrice() {
        return meatPrice;
    }

    public double getExtraMeatPrice() {
        return extraMeatPrice;
    }

    public double getCheesePrice() {
        return cheesePrice;
    }

    public double getExtraCheesePrice() {
        return extraCheesePrice;
    }

    public static Size fromInt(int i) {
        return switch (i) {
            case 4 -> FOUR;
            case 8 -> EIGHT;
            case 12 -> TWELVE;
            default -> null;
        };
    }
}
