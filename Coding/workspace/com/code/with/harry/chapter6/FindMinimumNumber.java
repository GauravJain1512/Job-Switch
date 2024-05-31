package com.code.with.harry.chapter6;

public class FindMinimumNumber {
    public static void main(String[] args) {
        int [] arr = {1,2,3,6,5,4,7,8,9,5,4,5,1,58,63};
        int min = Integer.MAX_VALUE;
        for (int i : arr){
            if (i< min){
                min = i;
            }
        }
        System.out.println(min);
    }
}
