package com.code.with.harry.chapter2;

import java.util.Scanner;

public class UserNumberValidator {

    public static void main(String[] args) {
        int refNumber = 10;

        Scanner scanner = new Scanner(System.in);
        int userNumber = scanner.nextInt();
        if(refNumber > userNumber){
            System.out.println("Your number is smaller");
        } else if (refNumber < userNumber) {
            System.out.println("Your number is larger");

        }else {
            System.out.println("Your number is equal");
        }
    }
}
