package com.code.with.harry.chapter7;

import java.util.Scanner;

public class SumOfFirstN_NaturalNumbers {
    public static void main(String[] args) {
        System.out.println("Please enter number:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sum = printSumOfNaturalNumber(number);
        System.out.println(sum);
    }

    private static int printSumOfNaturalNumber(int number) {
        if(number == 0){
            return 0;
        }else {
            return number + printSumOfNaturalNumber(number - 1);
        }
    }
}
