package com.pluralsight.types;

public enum Topping {
    LETTUCE,
    PEPPERS,
    ONIONS,
    TOMATOES,
    JALAPENOS,
    CUCUMBERS,
    PICKLES,
    GUACAMOLE,
    MUSHROOMS;

    public static Topping fromString(String input) {
        try {
            return Topping.valueOf(input.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
