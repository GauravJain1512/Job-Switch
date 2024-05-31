package com.code.with.harry.chapter4;

import java.util.Scanner;

public class LeapYearIdentifier {

    public static void main(String[] args) {
        System.out.println("Please enter year: ");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        if (year % 100 == 0){
            if (year % 400 == 0){
                System.out.println("Leap Year");
            }else {
                System.out.println("Not Leap Year");
            }
        }else {
            if (year % 4 == 0){
                System.out.println("Leap Year");
            }else {
                System.out.println("Not Leap Year");
            }
        }
    }
}
