package com.code.with.harry.chapter5;

import java.util.Scanner;

public class TableGenerator {
    public static void main(String[] args) {
        System.out.println("Please enter number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for (int i = 1; i<=10; i++){
            System.out.println(number*i);
        }
    }
}
