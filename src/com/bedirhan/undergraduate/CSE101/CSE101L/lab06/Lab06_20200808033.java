package com.bedirhan.undergraduate.CSE101.CSE101L.lab06;

import java.util.Scanner;
public class Lab06_20200808033 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Please enter the bound: ");
        int number= inp.nextInt();
        isqualified(number);
        for (int i=2 ; i<number ; i++){

            if(isqualified(i)){
                System.out.println(i);
            }
        }


    }
    public static boolean isqualified(int num){
        int sum=0;

        for (int a=1 ; a<num ; a++){
            if (num%a==0){
                sum+=a;
            }
        }
        if (sum==num){
            return true;
        }
        else
            return false;
    }
}

