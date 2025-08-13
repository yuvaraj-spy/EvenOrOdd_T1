package org.task;

import java.util.Scanner;

public class EvenOrOdd {
	public static void main(String[] args) {
        // Create Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Ask the user for a number
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Check if the number is even or odd using modulus operator
        if (number % 2 == 0) {
            System.out.println(number + " is Even.");
        } else {
            System.out.println(number + " is Odd.");
        }

        // Close scanner to prevent resource leak
        scanner.close();
    }

}
