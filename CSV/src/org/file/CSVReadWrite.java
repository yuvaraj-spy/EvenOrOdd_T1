package org.file;

	import java.io.*;
	import java.nio.file.*;
	import java.util.*;

	public class CSVReadWrite {
	    public static void main(String[] args) {
	        String inputFile = "products.csv";
	        String outputFile = "filtered_products.csv";

	        // Show where the program is looking for files
	        System.out.println("Working dir = " + new File(".").getAbsolutePath());

	        try {
	            Path inPath = Paths.get(inputFile);

	            // If products.csv doesn't exist, create a sample one
	            if (!Files.exists(inPath)) {
	                System.out.println("products.csv not found. Creating a sample file...");
	                List<String> sample = Arrays.asList(
	                    "Laptop,55000",
	                    "Phone,15000",
	                    "Headphones,800",
	                    "Keyboard,1200",
	                    "Mouse,600",
	                    "Monitor,9500"
	                );
	                Files.write(inPath, sample);
	                System.out.println("Sample products.csv created at: " + inPath.toAbsolutePath());
	            }

	            // Read & filter, then write
	            try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
	                 FileWriter fw = new FileWriter(outputFile)) {

	                String line;
	                while ((line = br.readLine()) != null) {
	                    line = line.trim();
	                    if (line.isEmpty()) continue;         // skip blank lines

	                    String[] parts = line.split(",");
	                    if (parts.length < 2) continue;        // skip malformed lines

	                    String name = parts[0].trim();
	                    String priceStr = parts[1].trim();

	                    try {
	                        double price = Double.parseDouble(priceStr);
	                        if (price > 1000) {
	                            fw.write(name + "," + price + System.lineSeparator());
	                        }
	                    } catch (NumberFormatException nfe) {
	                        // skip lines where price isn't a number
	                        System.out.println("Skipping invalid price line: " + line);
	                    }
	                }
	            }

	            System.out.println("Filtered products written successfully to " + outputFile);

	        } catch (IOException e) {
	            System.out.println("I/O Error: " + e.getMessage());
	        }
	    }
	}



