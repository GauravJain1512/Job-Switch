package com.code.with.harry.chapter5;

import java.util.Scanner;

public class FirstN_NaturalNumber {

    public static void main(String[] args) {
        System.out.println("How much first natural number you want:  ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int i = 1;
        do {
            System.out.println(i);
            i++;
        }while (i<= number);
    }
}
