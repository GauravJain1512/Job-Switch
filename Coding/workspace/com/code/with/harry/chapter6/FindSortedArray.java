package com.code.with.harry.chapter6;

public class FindSortedArray {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,8,9};
        boolean isSorted = true;
        for (int i = 0 ; i <arr.length-1;i++){
            if (arr[i] > arr[i+1]){
                isSorted = false;
                break;
            }
        }
        if (isSorted){
            System.out.println("Sorted Array");
        }else{
            System.out.println("Not Sorted Array");
        }
    }
}
