package com.bedirhan.undergraduate.CSE101.CSE101L.lab05;

import java.util.Scanner;

public class Lab05_20200808033 {
    public static void main(String[] args) {
        Scanner inp =  new Scanner(System.in);
        System.out.print("Enter first bound: ");
        int first= inp.nextInt();
        System.out.print("Enter second bound: ");
        int second = inp.nextInt();
        int calc=1;
        for (int i = first ; i <= second ; i++){

            if ( (i%2==0) || (i%3==0) ){
                if (((i%2==0) && (i%3==0))){
                    continue;
                }
                else {
                    if (calc<=10){
                        calc++;
                        System.out.print(i +"  ");
                    }
                    else {
                        System.out.println();
                        System.out.print(i +"  ");
                        calc-=10;
                    }
                }

            }
        }


    }
}


