package com.code.with.harry.chapter1;

import java.util.Scanner;

public class DistanceConvertor {
    public static void main(String[] args) {
        System.out.println("Please enter distance in KM: ");
        Scanner scanner = new Scanner(System.in);
        double distanceInKm = scanner.nextDouble();
        System.out.println("Distance in miles: "+(distanceInKm*0.62));
    }
}
