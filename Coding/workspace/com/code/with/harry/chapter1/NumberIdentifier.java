package com.code.with.harry.chapter1;

import java.util.Scanner;

public class NumberIdentifier {
    public static void main(String[] args) {
        System.out.println("Please enter number: ");
        Scanner scanner = new Scanner(System.in);
        try{
            int number = scanner.nextInt();
            System.out.println("Entered number is : "+number);
        }catch (Exception exception){
            System.out.println("you did not enter number ");
        }

    }
}
