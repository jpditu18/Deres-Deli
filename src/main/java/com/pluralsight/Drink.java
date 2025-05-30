package com.pluralsight;

import com.pluralsight.types.DrinkSize;

public class Drink {
    private String flavor;
    private DrinkSize size;

    public Drink(String flavor, DrinkSize size){
        this.flavor = flavor;
        this.size = size;
    }
    public double getPrice(){
        return size.getPrice();
    }
    @Override
    public String toString(){
        return size + " " + flavor + " - $" + String.format("%.2f", getPrice());
    }

}
