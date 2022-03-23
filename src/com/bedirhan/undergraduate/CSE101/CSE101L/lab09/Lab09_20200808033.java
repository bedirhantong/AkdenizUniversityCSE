package com.bedirhan.undergraduate.CSE101.CSE101L.lab09;


import java.util.Scanner;

/**
 * @author 20200808033 Bedirhan Tonğ
 * @version 10.12.2021
 */

public class Lab09_20200808033 {
    public static void main(String[] args) {


        deviation(getValuesFromUser(new Scanner(System.in)));


    }
    public static double[] getValuesFromUser(Scanner scanner){
        System.out.print("Please enter the length of the array : ");
        int size = scanner.nextInt();

        double[] arr = new double[size];

        for ( int i = 0 ; i<size ; i++){
            System.out.print("Please enter the "+ (i+1) +". element: ");
            arr[i]= scanner.nextDouble();
        }
        return arr;
    }
    public static double mean(double[] arr){
        double result;
        double total=0;
        for (int i = 0; i< arr.length ; i++){
            total+=arr[i];
        }
        result=total/ arr.length;

        return result;
    }
    public static double deviation(double arr[]){
        double result1=1;
        double result2;
        double a;

        for (int i= 0; i< arr.length ; i++){
            a=(arr[i]-mean(getValuesFromUser(new Scanner(System.in))))*(arr[i]-mean(getValuesFromUser(new Scanner(System.in))));
            result1+=a;

        }
        result1= result1/ arr.length;

        result2= Math.sqrt(result1);

        return result2;
    }


}

