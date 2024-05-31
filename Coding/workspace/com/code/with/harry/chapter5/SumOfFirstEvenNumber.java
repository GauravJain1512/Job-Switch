package com.code.with.harry.chapter5;

import java.util.Scanner;

public class SumOfFirstEvenNumber {
    public static void main(String[] args) {
        System.out.println("Enter Input here");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i< number ; i++){
            sum += 2;
        }
        System.out.println(sum);
    }
}
