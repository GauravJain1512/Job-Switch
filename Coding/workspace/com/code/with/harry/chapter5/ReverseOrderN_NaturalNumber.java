package com.code.with.harry.chapter5;

import java.util.Scanner;

public class ReverseOrderN_NaturalNumber {
    public static void main(String[] args) {
        System.out.println("Please enter input here");
        Scanner scanner = new Scanner(System.in);
        int naturalNumbers = scanner.nextInt();
        for (int i = naturalNumbers; i != 0 ; i--){
            System.out.println(i);
        }
    }
}
