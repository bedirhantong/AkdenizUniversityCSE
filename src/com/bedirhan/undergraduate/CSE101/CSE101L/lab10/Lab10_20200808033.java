package com.bedirhan.undergraduate.CSE101.CSE101L.lab10;


/**
 * @author Bedirhan 20200808033
 * @version 17.12.2021
 */

public class Lab10_20200808033 {
    public static void main(String[] args) {
        int[][] arr= { {1,2,3},{3,45,5} };
        System.out.println(isAllEqual(arr));

    }
    public static boolean isRowEqual(int[][] arr){ // her satır toplamı

        int a = arr.length;
        int b = arr[0].length;
        int sum=0;
        int[] arr1= new int[b];

        for (int i = 0 ; i< b ; i++ ){
            for (int j= 0 ; j< a ; j++){
                sum+=arr[b][a];
            }
            arr1[b]=sum;
            sum=0;
        }

        for (int i = 1 ; i <b ;i++){
            if ( arr1[i] != arr1[i-1]){
                return false;
            }
        }

        return true;
    }
    public static boolean isColumnEqual(int[][] arr){
        int a = arr.length;
        int b = arr[0].length;
        int sum=0;
        int[] arr1= new int[a];

        for (int i = 0 ; i< a ; i++ ){
            for (int j= 0 ; j< b ; j++){
                sum+=arr[b][a];
            }
            arr1[a]=sum;
            sum=0;
        }

        for (int i = 1 ; i <a ;i++){
            if ( arr1[i] != arr1[i-1]){
                return false;
            }
        }


        return true;
    }
    public static boolean isSquare(int[][] arr){
        if (arr.length == arr[0].length){
            return true;
        }
        return false;
    }
    public static boolean isAllEqual(int[][] arr){

        if (  isRowEqual(arr) && isColumnEqual(arr) && isSquare(arr)  ){
            return true;
        }

        return false;
    }
}

