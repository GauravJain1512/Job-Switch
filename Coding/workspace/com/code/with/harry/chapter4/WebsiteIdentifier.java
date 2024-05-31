package com.code.with.harry.chapter4;

import java.util.Scanner;

public class WebsiteIdentifier {

    public static void main(String[] args) {
        System.out.println("Please enter your website");
        Scanner scanner = new Scanner(System.in);
        String website = scanner.nextLine();
        if (website.contains(".com")){
            System.out.println("Commercial Website");
        } else if (website.contains(".org")) {
            System.out.println("Organisational Website");
        } else if (website.contains(".in")) {
            System.out.println("Indian Website");
            
        }
    }
}
