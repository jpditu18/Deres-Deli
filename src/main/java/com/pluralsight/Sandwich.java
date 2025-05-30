package com.pluralsight;

import com.pluralsight.types.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Sandwich {
    private Size size;
    private BreadType bread;
    private ArrayList<Meat> meats = new ArrayList<>();
    private ArrayList<Meat> extraMeats = new ArrayList<>();

    private ArrayList<Cheese> cheeses = new ArrayList<>();
    private ArrayList<Cheese> extraCheeses = new ArrayList<>();

    private ArrayList<Topping> toppings = new ArrayList<>();
    private ArrayList<Sauce> sauces = new ArrayList<>();

    private boolean toasted;

    public static Sandwich createSandwich() {
        Scanner scanner = new Scanner(System.in);
        Sandwich sandwich = new Sandwich();

        System.out.println("Size (4, 8, 12): ");
        sandwich.size = Size.fromInt(Integer.parseInt(scanner.nextLine()));

        System.out.println("Bread (White, Wheat, Rye, Wrap): ");
        sandwich.bread = BreadType.fromString(scanner.nextLine());

        // Meats
        System.out.println("Meats (Steak, Ham, Salami, Roast Beef, Chicken, Bacon): ");
        for (String m : scanner.nextLine().split(",")) {
            try {
                sandwich.meats.add(Meat.valueOf(m.trim().toUpperCase()));
            } catch (Exception e) {
                System.out.println("Invalid meat: " + m);
            }
        }

        System.out.println("Would you like extra meat? (yes/no): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            System.out.print("Add extra meat choice(s): ");
            for (String m : scanner.nextLine().split(",")) {
                try {
                    sandwich.extraMeats.add(Meat.valueOf(m.trim().toUpperCase()));
                } catch (Exception e) {
                    System.out.println("Invalid extra meat: " + m);
                }
            }
        }

        // Cheeses
        System.out.println("Cheeses (American, Provolone, Cheddar, Swiss): ");
        for (String c : scanner.nextLine().split(",")) {
            try {
                sandwich.cheeses.add(Cheese.valueOf(c.trim().toUpperCase()));
            } catch (Exception e) {
                System.out.println("Invalid cheese: " + c);
            }
        }

        System.out.println("Would you like extra cheese? (yes/no): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            System.out.print("Add extra cheese choice(s): ");
            for (String c : scanner.nextLine().split(",")) {
                try {
                    sandwich.extraCheeses.add(Cheese.valueOf(c.trim().toUpperCase()));
                } catch (Exception e) {
                    System.out.println("Invalid extra cheese: " + c);
                }
            }
        }

        // Toppings
        System.out.println("Toppings (Lettuce, Peppers, Onions, Tomatoes, Jalapenos, Cucumbers, Pickles, Guacamole, Mushrooms): ");
        for (String t : scanner.nextLine().split(",")) {
            try {
                sandwich.toppings.add(Topping.valueOf(t.trim().toUpperCase()));
            } catch (Exception e) {
                System.out.println("Invalid topping: " + t);
            }
        }

        // Sauces
        System.out.println("Sauces (Mayo, Mustard, Ketchup, Ranch, Barbeque, Vinaigrette): ");
        for (String s : scanner.nextLine().split(",")) {
            try {
                sandwich.sauces.add(Sauce.valueOf(s.trim().toUpperCase()));
            } catch (Exception e) {
                System.out.println("Invalid sauce: " + s);
            }
        }

        System.out.println("Toasted? (yes/no): ");
        sandwich.toasted = scanner.nextLine().trim().equalsIgnoreCase("yes");

        return sandwich;
    }

    public double calculatePrice() {
        double total = size.getBasePrice();
        total += meats.size() * size.getMeatPrice();
        total += extraMeats.size() * size.getExtraMeatPrice();
        total += cheeses.size() * size.getCheesePrice();
        total += extraCheeses.size() * size.getExtraCheesePrice();
        return total;
    }

    public void printDetails() {
        System.out.println(size.getInches() + "\" " + bread);
        System.out.println("Meats: " + meats);
        if (!extraMeats.isEmpty()) System.out.println("Extra Meats: " + extraMeats);

        System.out.println("Cheeses: " + cheeses);
        if (!extraCheeses.isEmpty()) System.out.println("Extra Cheeses: " + extraCheeses);

        System.out.println("Toppings: " + toppings);
        System.out.println("Sauces: " + sauces);
        System.out.println("Toasted: " + (toasted ? "Yes" : "No"));
        System.out.printf("Price: $%.2f\n", calculatePrice());
    }

    @Override
    public String toString() {
        return size + " " + bread + " sandwich with " +
                "Meats: " + meats + (!extraMeats.isEmpty() ? " + Extra: " + extraMeats : "") + ", " +
                "Cheeses: " + cheeses + (!extraCheeses.isEmpty() ? " + Extra: " + extraCheeses : "") + ", " +
                "Toppings: " + toppings + ", " +
                "Sauces: " + sauces + ", " +
                "Toasted: " + (toasted ? "Yes" : "No");
    }
}