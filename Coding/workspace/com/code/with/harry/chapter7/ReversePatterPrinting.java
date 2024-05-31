package com.code.with.harry.chapter7;

import java.util.Scanner;

public class ReversePatterPrinting {
    public static void main(String[] args) {
        System.out.println("Please enter number");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        printPatternInReverseOrder(number);
    }

    private static void printPatternInReverseOrder(int number) {
        for (int i = number; i != 0; i--){
            for (int j = i ; j != 0; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
