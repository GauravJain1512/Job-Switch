package com.code.with.harry.chapter5;

import java.util.Scanner;

public class FactorialFinder {
    public static void main(String[] args) {
        System.out.println("Please enter number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int factorial = 1;
//        for (int i = number; i != 1 ; i--){
//            factorial *= i;
//        }
        while (number >= 1){
            factorial *= number;
            number--;
        }
        System.out.println("Factorial is: "+factorial);
    }
}
