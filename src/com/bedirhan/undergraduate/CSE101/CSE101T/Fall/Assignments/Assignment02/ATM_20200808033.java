package com.bedirhan.undergraduate.CSE101.CSE101T.Fall.Assignments.Assignment02;

/**
 * @author Bedirhan
 * @version 23.10.2021
 */
import java.util.Scanner;
public class ATM_20200808033 {
    public static boolean isDepositValid(double amount){
        if (amount>0){
            return true;
        } else{
            return false;
        }
    }

    public static boolean isWithdrawalValid(double balance,double amountOfWithdrawn){
        if ( amountOfWithdrawn>0 && amountOfWithdrawn<=balance ){
            return true;
        } else {
            return false;
        }
    }

    public static String moneyGiven(double amount){
        double result1;
        String result="";
        int counter = 0;
        while (amount>=200){
            amount-=200;
            counter++;
        }
        String y = Integer.toString(counter);
        result=result.concat(y+" "+"-"+" "+"200"+"\n");
        counter=0;

        while (amount>=100){
            amount-=100;
            counter++;
        }
        String z = Integer.toString(counter);
        result=result.concat(z+" "+"-"+" "+"100"+"\n");
        counter=0;

        while (amount>=50){
            amount-=50;
            counter++;
        }
        String x = Integer.toString(counter);
        result=result.concat(x+" "+"-"+" "+"50"+"\n");
        counter=0;
        counter=0;

        while (amount>=20){
            amount-=20;
            counter++;
        }
        String a = Integer.toString(counter);
        result=result.concat(a+" "+"-"+" "+"20"+"\n");
        counter=0;

        while (amount>=10){
            amount-=10;
            counter++;
        }
        String b = Integer.toString(counter);
        result=result.concat(b+" "+"-"+" "+"10"+"\n");
        counter=0;

        while (amount>=5){
            amount-=5;
            counter++;
        }
        String c = Integer.toString(counter);
        result=result.concat(c+" "+"-"+" "+"5"+"\n");
        counter=0;

        while (amount>=1){
            amount-=1;
            counter++;
        }
        String c1 = Integer.toString(counter);
        result=result.concat(c1+" "+"-"+" "+"1"+"\n");
        counter=0;

        while (amount>=0.5){
            amount-=0.5;
            counter++;
        }
        String c2 = Integer.toString(counter);
        result=result.concat(c2+" "+"-"+" "+"0.5"+"\n");
        counter=0;

        while (amount>=0.25){
            amount-=0.25;
            counter++;
        }
        String c3 = Integer.toString(counter);
        result=result.concat(c3+" "+"-"+" "+"0.25"+"\n");
        counter=0;

        while (amount>=0.10){
            amount-=0.10;
            counter++;
        }
        String c4 = Integer.toString(counter);
        result=result.concat(c4+" "+"-"+" "+"0.10"+"\n");
        counter=0;

        while (amount>=0.05){
            amount-=0.05;
            counter++;
        }
        String c5 = Integer.toString(counter);
        result=result.concat(c5+" "+"-"+" "+"0.05"+"\n");
        counter=0;

        while (amount>=0.01){
            amount-=0.01;
            counter++;
        }
        String c6 = Integer.toString(counter);
        result=result.concat(c6+" "+"-"+" "+"0.01"+"\n");



        return result;
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Please enter your first name: ");
        String firstName=inp.nextLine();
        System.out.print("Please enter your second name: ");
        String secondName=inp.nextLine().toUpperCase();
        double balance;
        while (true){
            System.out.print("Please enter your starting balance: ");
            balance=inp.nextDouble();
            if (balance>=0){
                break;
            }
            System.out.println("ERROR: Invalid balance");
        }
        System.out.println();

        while (true) {
            System.out.println("Hello "+firstName+" "+secondName);
            System.out.println("What would you like to do today?");
            System.out.println("""
                    1 for Account Balance
                    2 for Cash Deposit
                    3 for Cash Withdrawal
                    0 to quit""");
            System.out.print("Please enter your selection: ");
            int selection = inp.nextInt();
            if (selection == 1) {
                System.out.println("Your account balance is: " + balance + "\n");
            } else if (selection == 2) {
                System.out.print("How much are you depositing? ");
                double deposit = inp.nextDouble();
                if ( isDepositValid(deposit) ){
                    balance += deposit;
                }else {
                    System.out.println("ERROR: Invalid deposit amount");
                }
                System.out.println();
            } else if (selection == 3) {
                System.out.print("How much are you withdrawing? ");
                double withdraw = inp.nextDouble();
                if ( isWithdrawalValid(balance,withdraw)){
                    balance -= withdraw;
                    System.out.println("You will receive the following: ");
                    System.out.println(moneyGiven(withdraw));
                }else{
                    System.out.println("ERROR: Invalid withdrawal amount");
                }
                System.out.println();
            } else if (selection == 0) {
                System.out.println("Thank you for using our ATM. Have a nice day!");
                break;
            } else {
                System.out.println("Invalid choice. Exiting System.");
                break;
            }
        }
    }


}

