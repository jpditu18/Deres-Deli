package com.pluralsight;

import com.pluralsight.types.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Sandwich {
    private Size size;
    private BreadType bread;
    private ArrayList<Meat> meats = new ArrayList<>();
    private ArrayList<Cheese> cheeses = new ArrayList<>();
    private ArrayList<Topping> toppings = new ArrayList<>();
    private ArrayList<Sauce> sauces = new ArrayList<>();
    private boolean toasted;

    public static Sandwich createSandwich(){
        Scanner scanner = new Scanner(System.in);
        Sandwich sandwich = new Sandwich();

        System.out.println("Size (4, 8, 12): ");
        sandwich.size = Size.fromInt(Integer.parseInt(scanner.nextLine()));

        System.out.println("Bread (White, Wheat, Rye, Wrap): ");
        sandwich.bread = BreadType.fromString(scanner.nextLine());

        System.out.println("Meats (Steak, Ham, Salami, Roast Beef, Chicken, Bacon): ");
        for (String m : scanner.nextLine().split(",")){
            try {
                sandwich.meats.add(Meat.valueOf(m.trim().toUpperCase()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Cheeses (American, Provolone, Cheddar, Swiss): ");
        for (String c : scanner.nextLine().split(",")){
            try {
                sandwich.cheeses.add(Cheese.valueOf(c.trim().toUpperCase()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Toppings (Lettuce, Peppers, Onions, Tomatoes, Jalapenos, Cucumbers, Pickles, Guacamole, Mushrooms): ");
        for (String t : scanner.nextLine().split(",")){
            try {
                sandwich.toppings.add(Topping.valueOf(t.trim().toUpperCase()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Sauces (Mayo, Mustard, Ketchup, Ranch, Barbeque, Vinaigrette): ");
        for (String s : scanner.nextLine().split(",")){
            try {
                sandwich.sauces.add(Sauce.valueOf(s.trim().toUpperCase()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Toasted? (yes/no): ");
        sandwich.toasted = scanner.nextLine().equalsIgnoreCase("yes");

        return sandwich;
    }
    public double calculatePrice(){
        double total = size.getBasePrice();
        total += meats.size() * size.getMeatPrice();
        total += cheeses.size() * size.getCheesePrice();
        return total;
        }
        public void printDetails(){
        System.out.println(size.getInches() + "\" " + bread);
        System.out.println("Meats: " + meats);
        System.out.println("Chesses: " + cheeses);
        System.out.println("Toppings: " + toppings);
        System.out.println("Sauces: " + sauces);
        System.out.println("Toasted: " + (toasted ? "Yes" : "No"));
        System.out.printf("Price: $%.2f\n", calculatePrice());
    }
    @Override
    public String toString(){
        return size + " " + bread + " with " + meats + ", " + cheeses + ", " + toppings + ", " + sauces;
    }
}
