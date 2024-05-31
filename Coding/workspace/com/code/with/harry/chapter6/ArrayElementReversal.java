package com.code.with.harry.chapter6;

public class ArrayElementReversal {
    public static void main(String[] args) {
        int [] arr = {1,2,3,6,5,4,8,9,5};
//        int [] arrResult = new int[arr.length];
//        int j = 0;
//        for (int i = arr.length-1; i >=0; i--){
//            arrResult[j] = arr[i];
//            j++;
//        }
//        for (int i : arrResult){
//            System.out.print(i+" ");
//        }
       int n = Math.floorDiv(arr.length, 2);
       for (int i = 0; i<n; i++){
           int temp = arr[i];
           arr[i] = arr[arr.length-i-1];
           arr[arr.length-i-1] = temp;
       }
       for (int i : arr){
           System.out.print(i+" ");
       }
    }
}
