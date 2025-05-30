package com.pluralsight;

public class Chip {
    private String type;
    private static final double PRICE = 1.50;

    public Chip(String type) {
        this.type = type;
    }
    public double getPrice(){
        return PRICE;
    }

    @Override
    public String toString(){
        return type + " - $" + String.format("%.2f", PRICE);
    }
}
