package com.code.with.harry.chapter6;

public class SumOfArrayElement {
    public static void main(String[] args) {
        float[] arr = {1.0f,2.0f,3.0f,4.0f,5.0f};
        float sum = 0f;
        int i = 0;
        for (float f : arr){
            sum += arr[i];
            i++;
        }
        System.out.println(sum);
    }
}
