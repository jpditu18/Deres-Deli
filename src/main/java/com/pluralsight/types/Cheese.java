package com.pluralsight.types;

public enum Cheese {
    AMERICAN,
    PROVOLONE,
    CHEDDAR,
    SWISS;

    public static Cheese fromString(String input) {
        try {
            return Cheese.valueOf(input.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
