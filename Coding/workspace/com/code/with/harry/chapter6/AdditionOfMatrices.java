package com.code.with.harry.chapter6;

public class AdditionOfMatrices {
    public static void main(String[] args) {
        int [][] arr1 = {{1,2,3},{4,5,6}};
        int [][] arr2 = {{1,2,3},{4,5,6}};

        int [][] arrResult = new int[2][3];

        for (int i = 0 ; i< arr1.length ; i++){
            for (int j =0 ; j<arr1[i].length ; j++){
                arrResult [i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        for (int i = 0; i < arrResult.length ; i++){
            for (int j = 0 ; j< arrResult[i].length; j++){
                System.out.print(arrResult[i][j]+" ");
            }
            System.out.println();
        }
    }
}
