package com.code.with.harry.chapter7;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.println("Please enter number");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        printMultiplicationTable(number);
    }

    private static void printMultiplicationTable(int number) {
        for (int i = 1; i<= 10; i++){
            System.out.println(number*i);
        }
    }
}
