package com.bedirhan.undergraduate.CSE101.CSE101L.lab08;

/**
 * @author Bedirhan Tonğ ( 20200808033 )
 * @version 03.12.2021
 */
import java.util.Scanner;

public class Lab08_20200808033 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Please enter the length of the array : ");
        int length= inp.nextInt();

        double[] arr = new double[length];

        for (int i=0 ; i< arr.length ; i++){
            System.out.print("Please enter the "+(i+1)+". element:");
            arr[i]= inp.nextDouble();
        }

        System.out.println("Sum of the array: "+sum(arr));
        System.out.println("Average of the array: "+average(arr));
        System.out.println("Minimum element: "+findMin(arr));

    }

    public static double sum(double[] arr){
        double result =0;
        for (int i=0 ; i< arr.length ; i++){
            result+= arr[i];
        }

        return result;
    }

    public static double average( double[] arr){
        double average = sum(arr)/ arr.length;

        return average;
    }

    public static double findMin( double[] arr){
        double min = arr[0];

        for (int i=1 ; i< arr.length ; i++){
            if (arr[i]< min){
                min= arr[i];
            }
        }
        return min;
    }


}
