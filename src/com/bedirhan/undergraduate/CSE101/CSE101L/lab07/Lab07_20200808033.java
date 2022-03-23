package com.bedirhan.undergraduate.CSE101.CSE101L.lab07;

import java.util.Scanner;
public class Lab07_20200808033 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter a bound  : ");
        int bound = inp.nextInt();
        System.out.print(getTwinPrimes(bound));




    }
    public static String getTwinPrimes(int bound){
        int count=0;
        String result= "";

        for (int i =2 ; i  <=  bound ; i++){

            if (isPrime(i)){
                count++;
                String str = String.valueOf(i);
                result=result.concat(str);
                if (count!=2){
                    result=result.concat("-");
                }

                if (count==2){
                    result=result.concat("\n");
                    str = String.valueOf(i);
                    result= result.concat(str);
                    result=result.concat("-");
                }
            }
        }
        return result;
    }
    public static boolean isPrime(int number){
        for (int i = 2 ; i<= number/2 ; i++){
            if (number%i==0){
                return false;
            }
        }
        return true;
    }
}

