package com.code.with.harry.chapter5;

import java.util.Scanner;

public class OddNumberPrinter {
    public static void main(String[] args) {
        System.out.println("First n odd number");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int oddNumber = 1;
        for (int i = 1 ; i<=number; i++){
            System.out.println(oddNumber);
            oddNumber += 2;
        }
    }
}
