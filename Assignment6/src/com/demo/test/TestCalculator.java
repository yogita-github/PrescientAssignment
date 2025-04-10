package com.demo.test;

import com.demo.service.*;
import java.util.Scanner;

public class TestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nChoices:");
            System.out.println("1. Add \n2. Subtract \n3. Multiply \n4. Divide \n5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exiting the program...");
                break;
            }

            try {
                System.out.print("Enter first number: ");
                int num1 = scanner.nextInt();
                System.out.print("Enter second number: ");
                int num2 = scanner.nextInt();

                if (num1 < 0 || num2 < 0) {
                    System.out.println("Error: Negative numbers are not allowed. Please enter positive values.");
                    continue;
                }

                float result = 0;
                switch (choice) {
                    case 1:
                        result = Calculator.add(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 2:
                        result = Calculator.subtract(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 3:
                        result = Calculator.multiply(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 4:
                        try {
                            result = Calculator.divide(num1, num2);
                            System.out.println("Result: " + result);
                        } catch (ArithmeticException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Invalid choice! Please select a valid option.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter valid numbers.");
                scanner.nextLine();
            }
        } while (choice != 5);

        scanner.close();
    }
}
