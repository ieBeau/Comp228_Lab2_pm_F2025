package com.pm.lab2;

import java.util.Scanner;
import java.math.BigDecimal;

public class MainDriver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Interest[] interests = new Interest[5];

        for (int i = 0; i < 5; i++) {
            try {

                System.out.println("\nEnter values for Interest " + (i + 1) + ": ");
                
                System.out.print("  Principal: ");
                Double principal = Double.valueOf(scanner.nextLine());

                System.out.print("  Rate (%): ");
                BigDecimal rate = new BigDecimal(scanner.nextLine());

                System.out.print("  Time (years): ");
                Double time = Double.valueOf(scanner.nextLine());

                interests[i] = new Interest(principal, rate, time);
            } catch (IllegalArgumentException e) {
                System.out.println("Error creating Interest " + (i + 1) + ": " + e.getMessage());
            }
        }

        for (int i = 0; i < interests.length; i++) {
            if (interests[i] != null) {
                System.out.println("\nInterest " + (i + 1) + " (" + interests[i].GetTime() + " years):");
                System.out.println("    Simple Interest: $" + interests[i].SimpleInterest());
                System.out.println("    Compound Interest: $" + interests[i].CompoundInterest());
            }
        }

        scanner.close();

    }
}
