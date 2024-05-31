package com.code.with.harry.chapter4;

import java.util.Scanner;

public class ResultCalculator {
    public static void main(String[] args) {
        System.out.println("Enter Marks for Subject 1: ");
        Scanner scanner = new Scanner(System.in);
        int subject1 = scanner.nextInt();
        System.out.println("Enter Marks for Subject 2: ");
        int subject2 = scanner.nextInt();
        System.out.println("Enter Marks for Subject 3: ");
        int subject3 = scanner.nextInt();
        double percentage = (subject1 + subject2 + subject3 ) / 3.0 ;
        if (subject1< 33 || subject2 < 33 || subject3 < 33){
            System.out.println("You are failed");
        }else if (percentage< 45) {
            System.out.println("You are failed");
        }else {
            System.out.println("You are Pass");
        }
    }
}
