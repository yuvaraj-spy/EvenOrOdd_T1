package org.csvexceptionhandling;

import java.io.*;

//Custom exception for invalid product rows
class InvalidProductDataException extends Exception {
 public InvalidProductDataException(String message) {
     super(message);
 }
}

public class RobustCSVReadWrite {
 public static void main(String[] args) {
     String inputFile = "products.csv";
     String outputFile = "filtered_products.csv";

     BufferedReader br = null;
     FileWriter fw = null;

     // Show working directory so you know where files are expected
     System.out.println("Working dir = " + new File(".").getAbsolutePath());

     try {
         br = new BufferedReader(new FileReader(inputFile));
         fw = new FileWriter(outputFile);

         String line;
         while ((line = br.readLine()) != null) {
             line = line.trim();
             if (line.isEmpty()) continue; // skip blank lines

             try {
                 String[] parts = line.split(",");
                 if (parts.length < 2) {
                     throw new InvalidProductDataException("Invalid row (missing columns): " + line);
                 }

                 String name = parts[0].trim();
                 String priceStr = parts[1].trim();
                 double price;

                 try {
                     price = Double.parseDouble(priceStr);
                 } catch (NumberFormatException e) {
                     throw new InvalidProductDataException("Invalid price for product: " + name + " -> " + priceStr);
                 }

                 if (price > 1000) {
                     fw.write(name + "," + price + System.lineSeparator());
                 }

             } catch (InvalidProductDataException e) {
                 // log error to console and continue processing next rows
                 System.out.println("Error: " + e.getMessage());
             }
         }

         System.out.println("Filtered products written successfully to " + outputFile);

     } catch (FileNotFoundException e) {
         System.out.println("Error: Input file not found -> " + inputFile);
     } catch (IOException e) {
         System.out.println("I/O Error: " + e.getMessage());
     } finally {
         // always close resources
         try {
             if (br != null) br.close();
             if (fw != null) fw.close();
         } catch (IOException e) {
             System.out.println("Error closing resources: " + e.getMessage());
         }
     }
 }
}

