package com.code.with.harry.chapter3;

import java.util.Scanner;

public class DetectEmptySpaces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name");
        String fullName = scanner.nextLine();
        System.out.println("Is your name has empty spaces : " + fullName.contains("  "));
    }
}
