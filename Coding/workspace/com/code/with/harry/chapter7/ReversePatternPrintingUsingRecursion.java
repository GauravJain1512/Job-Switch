package com.code.with.harry.chapter7;

import java.util.Scanner;

public class ReversePatternPrintingUsingRecursion {
    public static void main(String[] args) {
        System.out.println("Please enter number");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        printPatternWithRecursion(number);
    }

    private static void printPatternWithRecursion(int number) {
        if (number < 1 ){
            return;
        }
        for (int i = 0; i< number ;i++){
            System.out.print("*");
        }
        System.out.println();
        printPatternWithRecursion(number-1);
    }
}
