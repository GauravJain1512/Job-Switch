package com.code.with.harry.chapter1;

import java.util.Scanner;

public class AdditionOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 1st number: ");
        int number1 = scanner.nextInt();
        System.out.println("Please enter 2nd number: ");
        int number2 = scanner.nextInt();
        System.out.println("Please enter 3rd number: ");
        int number3 = scanner.nextInt();

        System.out.printf("Addition of given numbers is: %d", (number1 + number2 + number3));
    }
}
