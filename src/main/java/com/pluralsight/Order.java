package com.pluralsight;

import com.pluralsight.types.DrinkSize;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private ArrayList<Sandwich> sandwiches = new ArrayList<>();
    private ArrayList<Drink> drinks = new ArrayList<>();
    private ArrayList<Chip> chips = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public void startOrder(){
        while (true){
        System.out.println("\n===== Order Screen =====");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");
        System.out.println("Enter choice: ");

        String choice = scanner.nextLine();

        switch (choice){
            case "1":
                sandwiches.add(Sandwich.createSandwich());

                System.out.println("Would you like to add a drink with that? (yes/no)");
                String drinkChoice = scanner.nextLine().trim().toLowerCase();
                if (drinkChoice.equals("yes") || drinkChoice.equals("y")){
                    addDrink();
                }
                System.out.println("Would you like to add chips as well? (yes/no)");
                String chipChoice = scanner.nextLine().trim().toLowerCase();
                if (chipChoice.equals("yes") || chipChoice.equals("y")){
                    addChip();
                }
                System.out.println("Would you like to add anything else? (yes to continue, no to checkout): ");
                String more = scanner.nextLine().trim().toLowerCase();
                if (more.equals("no") || more.equals("n")) {
                    Checkout();
                    return;
            }
                break;
            case "2":
                addDrink();
                System.out.println("Would you like to add anything else? (yes to continue, no to checkout): ");
                String moreDrink = scanner.nextLine().trim().toLowerCase();
                if (moreDrink.equals("no") || moreDrink.equals("n")) {
                    Checkout();
                    return;
                }
                break;
            case "3":
                addChip();
                System.out.println("Would you like to add anything else? (yes to continue, no to checkout): ");
                String moreChip = scanner.nextLine().trim().toLowerCase();
                if (moreChip.equals("no") || moreChip.equals("n")) {
                    Checkout();
                    return;
                    }
                break;
            case "4":
                Checkout();
                return;
            case "0":
                System.out.println("Order cancelled");
                return;
            default:
                System.out.println("Invalid input");
        }
    }
    }
    private void addDrink(){
        System.out.println("What would you like to drink? ");
        System.out.println("\n===== Drinks Menu =====");
        System.out.println("Available flavors:");
        System.out.println("1) Kool-Aid");
        System.out.println("2) Grape Soda");
        System.out.println("3) Fruit Punch");
        System.out.println("\nSelect a drink (enter number): ");
        String drinkChoice = scanner.nextLine();
        String flavor = "";

        switch (drinkChoice){
            case "1":
                flavor = "Kool-Aid";
                break;
            case "2":
                flavor = "Grape Soda";
                break;
            case "3":
                flavor = "Fruit Punch";
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        System.out.println("What size?(Small, Medium, Large) ");
        try {
            DrinkSize size = DrinkSize.valueOf(scanner.nextLine().toUpperCase());
            drinks.add(new Drink(flavor, size));
        } catch (Exception e) {
            System.out.println("We don't have that size, please make another selection");
        }
    }
    private void addChip(){
        System.out.println("What flavor of chips would you like? ");
        System.out.println("\n===== Chips Menu =====");
        System.out.println("Available flavors:");
        System.out.println("1) Baked Cheetos");
        System.out.println("2) Lays Original");
        System.out.println("3) Cool Ranch Doritos");
        System.out.println("Select a chip flavor (enter number): ");
        String chipChoice = scanner.nextLine();
        String flavor = "";

        switch (chipChoice){
            case "1":
                flavor = "Baked Cheetos";
                break;
            case "2":
                flavor = "Lays Original";
                break;
            case "3":
                flavor = "Cool Ranch Doritos";
                break;
            default:
                System.out.println("Invalid Selection");
                return;
        }
        chips.add(new Chip(flavor));
    }
    private void Checkout(){
        double total = 0;
        System.out.println("\n===== Order Summary =====");

        for (Sandwich s : sandwiches){
            s.printDetails();
            total += s.calculatePrice();
        }

        for (Drink d : drinks){
            System.out.println("Drink: " + d);
            total += d.getPrice();
        }

        for (Chip c : chips){
            System.out.println("Chips: " + c);
            total += c.getPrice();
        }

        System.out.printf("Total: $%.2f\n", total);
        ReceiptWriter.writeReceipt(this);
    }

    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<Chip> getChips() {
        return chips;
    }
}
