package com.code.with.harry.chapter1;

import java.util.Scanner;

public class PercentageCalculator {

    public static void main(String[] args) {
        System.out.println("Welcome to Percentage calculator, Please enter total number of subject");
        Scanner scanner = new Scanner(System.in);
        int totalSubjects = scanner.nextInt();
        int totalMarks = 0;
        for (int i = 1; i<= totalSubjects; i++){
            System.out.printf("Enter marks of subject number:  %d ", i);
            int marks = scanner.nextInt();
            totalMarks = totalMarks + marks;
        }

        System.out.println("Percentage is :" + (totalMarks/(totalSubjects*1.0)));


    }
}
