package com.pluralsight.types;

public enum Meat {
    STEAK,
    HAM,
    SALAMI,
    ROAST_BEEF,
    CHICKEN,
    BACON;
    public static Meat fromString(String input) {
        try {
            return Meat.valueOf(input.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}
