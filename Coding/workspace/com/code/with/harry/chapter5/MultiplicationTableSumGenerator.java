package com.code.with.harry.chapter5;

public class MultiplicationTableSumGenerator {
    public static void main(String[] args) {
        int number = 8;
        int sum = 0;
        for(int i = 1; i<= 10; i++ ){
            sum = sum + (number*i);
        }
        System.out.println(sum);
    }
}
