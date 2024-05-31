package com.code.with.harry.chapter6;

public class FindAverageMarks {
    public static void main(String[] args) {
        int []  marks = {10,20,30,40,50};
        int sum = 0;
        for (int mark : marks){
            sum += mark;
        }
        System.out.println(sum/(marks.length));
    }
}
