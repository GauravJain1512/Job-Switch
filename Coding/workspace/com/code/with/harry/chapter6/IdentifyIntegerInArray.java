package com.code.with.harry.chapter6;

import java.util.Scanner;

public class IdentifyIntegerInArray {
    public static void main(String[] args) {
        System.out.println("Please enter input here");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int [] arr = {1,2,3,6,5,4,7,8,9,63};
        boolean flag = false;
        for (int i : arr){
            if (i == number){
                flag = true;
                break;
            }
        }
        if (flag){
            System.out.println("Number is present in array");
        }else {
            System.out.println("Number is not present in array");
        }
    }
}
