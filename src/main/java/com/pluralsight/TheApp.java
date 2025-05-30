package com.pluralsight;

import java.util.Scanner;

public class TheApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){ showHomeScreen(); }

    private static void showHomeScreen(){
        while (true){
            System.out.println("\n            ===== Home Screen =====" + "\nWelcome to Dere's Deli where everything is Delicious!");
            System.out.println("\nWhat can we get started for you today?");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.println("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    Order order = new Order();
                    order.startOrder();
                    break;
                case "0":
                    System.out.println("Thank you for visiting Dere's Deli. Come see us again soon.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    }
}
