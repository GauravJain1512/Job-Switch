package com.code.with.harry.chapter7;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        System.out.println("Please enter input");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
       int nTerm =  findNTermOfFibonacciSeries(number);
        System.out.println(nTerm);
    }

    private static int  findNTermOfFibonacciSeries(int number) {
        if (number == 0 || number == 1){
            return number;
        }else {
            return findNTermOfFibonacciSeries(number-1) + findNTermOfFibonacciSeries(number -2);
        }

    }
}
