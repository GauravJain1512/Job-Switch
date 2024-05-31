package com.code.with.harry.chapter7;

import java.util.Scanner;

public class PatternPrinting {
    public static void main(String[] args) {
        System.out.println("Please enter number");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        printPattern(number);
    }

    private static void printPattern(int number) {
        for (int i = 1; i<= number ;i++){
            for (int j = 1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
