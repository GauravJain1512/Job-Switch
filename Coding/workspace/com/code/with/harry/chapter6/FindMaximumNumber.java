package com.code.with.harry.chapter6;

public class FindMaximumNumber {
    public static void main(String[] args) {
        int max = 0;
        int [] arr = {1,2,3,6,5,4,78,9,6,63};
        for (int i : arr){
            if (i>max){
                max = i;
            }
        }
        System.out.println(max);
    }
}
