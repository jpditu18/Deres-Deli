package com.pluralsight.types;

public enum Sauce {
    MAYO,
    MUSTARD,
    KETCHUP,
    RANCH,
    THOUSAND_ISLANDS,
    VINAIGRETTE,
    AU_JUS,
    SAUCE;

    public static Sauce fromString(String input) {
        try {
            return Sauce.valueOf(input.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
