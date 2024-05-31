package com.code.with.harry.chapter7;

import java.util.Scanner;

public class FactorialRecursion {
    public static void main(String[] args) {
        System.out.println("Please enter number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int factorial = calculateFactorial(number);
        System.out.println("Factorial is: "+factorial);
    }

    private static int calculateFactorial(int number) {
        if (number == 0 || number == 1){
            return 1;
        }else {
            return number * calculateFactorial(number- 1);
        }
    }
}
