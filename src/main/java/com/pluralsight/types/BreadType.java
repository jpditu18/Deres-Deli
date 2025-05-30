package com.pluralsight.types;

public enum BreadType {
    WHITE,
    WHEAT,
    RYE,
    WRAP;

    public static BreadType fromString(String input) {
        try {
            return BreadType.valueOf(input.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
