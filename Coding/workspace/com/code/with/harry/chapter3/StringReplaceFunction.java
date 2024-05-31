package com.code.with.harry.chapter3;

import java.util.Scanner;

public class StringReplaceFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name");
        String fullName = scanner.nextLine();
        System.out.println("After replace function call : "+ fullName.replace(" ","_"));
    }
}
