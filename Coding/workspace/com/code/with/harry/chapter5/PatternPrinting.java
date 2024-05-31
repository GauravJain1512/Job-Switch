package com.code.with.harry.chapter5;

public class PatternPrinting {
    public static void main(String[] args) {
//        for (int i = 4; i != 0 ; i--){
//            for (int j = i ; j != 0 ; j--){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
        int i = 4;
        while (i != 0){
            int j = i;
            while (j != 0 ){
                System.out.print("*");
                j--;
            }
            System.out.println();
            i--;
        }
    }
}
