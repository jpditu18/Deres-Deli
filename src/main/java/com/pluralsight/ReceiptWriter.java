package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void writeReceipt(Order order){
        try {
            new File("receipts");
            String filename = "receipts/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
            PrintWriter writer = new PrintWriter(new FileWriter(filename));

            for (Sandwich s : order.getSandwiches()) writer.println("Sandwich: " + s);
            for (Drink d : order.getDrinks()) writer.println("Drink: " + d);
            for (Chip c : order.getChips()) writer.println("Chip: " + c);

            writer.println("Thanks for dining with us!");
            writer.close();
        } catch (Exception e) {
            System.out.println("Could not write receipt");
        }
    }
}
