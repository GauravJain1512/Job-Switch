package com.code.with.harry.chapter4;

import java.util.Scanner;

public class IncomeTaxCalculator {

    public static void main(String[] args) {
        System.out.println("Please enter your income: ");
        Scanner scanner = new Scanner(System.in);
        double income = scanner.nextDouble();
        double incomeTax = 0.0f;
        if(income < 250000){
            System.out.println("Your income tax is 0 Rs");
        } else if (income > 250000 && income < 500000) {
            incomeTax = (income - 250000) * 0.05;
            System.out.printf("Your income tax is %f Rs", incomeTax);
        } else if (income > 500000 && income < 1000000) {
            incomeTax = (income - 500000) * 0.2;
            incomeTax = incomeTax + (500000*0.05);
            System.out.printf("Your income tax is %f Rs", incomeTax);
        } else if (income > 1000000) {
            incomeTax = (income - 1000000) * 0.3;
            incomeTax = incomeTax + (500000*0.2) + (250000*0.05);
            System.out.printf("Your income tax is %f Rs", incomeTax);
        }
    }
}
