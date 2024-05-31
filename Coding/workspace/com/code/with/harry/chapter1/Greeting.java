package com.code.with.harry.chapter1;

import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        System.out.println("Please enter you name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        System.out.println("Hello "+name+ ", Good Morning!, Have a nice day");
    }
}
