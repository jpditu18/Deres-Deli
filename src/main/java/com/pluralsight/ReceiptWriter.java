package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void writeReceipt(Order order){
        File receiptsDir = new File("receipts");
        if (!receiptsDir.exists()){
            receiptsDir.mkdir();
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String filename = "receipts/" + now.format(formatter) + ".txt";

        try(FileWriter writer = new FileWriter(filename)) {
            writer.write("===== Dere's Deli Receipt =====\n\n");
            writer.write("Order Date: \n" + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss\n")));

            double total = 0.0;

            writer.write("Sandwiches:\n");
            for (Sandwich s : order.getSandwiches()) {
                writer.write("- " + s.toString() + "\n");
                total += s.calculatePrice();
            }

            writer.write("\nDrinks:\n");
            for (Drink d : order.getDrinks()) {
                writer.write("- " + d.toString() + "\n");
                total += d.getPrice();
            }

            writer.write("\nChips:\n");
            for (Chip c : order.getChips()) {
                writer.write("- " + c.toString() + "\n");
                total += c.getPrice();
            }

            writer.write("\n------------------------------\n");
            writer.write(String.format("\nTOTAL: $%.2f\n", total));
            writer.write("Thanks for dining with us! Come see us again soon!");

            System.out.println("\nThanks for dining with us! Come see us again soon!");
            System.out.println("Receipt saved to: " + filename);
        } catch (Exception e) {
            System.out.println("Error writing receipt: " + e.getMessage());
        }
    }
}
