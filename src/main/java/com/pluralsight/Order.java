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
                break;
            case "2":
                addDrink();
                break;
            case "3":
                addChip();
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
        String flavor = scanner.nextLine();
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
        chips.add(new Chip(scanner.nextLine()));
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
