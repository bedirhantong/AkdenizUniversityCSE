package com.bedirhan.undergraduate.CSE101.CSE101T.Fall.Assignments.Assignment03;

/**
 * @author Bedirhan Tong
 * @version 07.12.2021
 */

import java .util.Scanner;

public class ATM_20200808033 {

    public static void bankLogin(int[] acctNums , String[] acctNames , String[] acctSurnames ,String[]  acctPINs , double[] acctBalances ){
        Scanner inp = new Scanner(System.in);
        System.out.print("Please enter your account number >> ");
        int acctNum= inp.nextInt();
        inp.nextLine();
        System.out.print("Please enter your PIN >> ");
        String pin = inp.nextLine();


        boolean pinResult = false;
        for ( int i = 0 ; i < acctPINs.length ; i++){
            if ( pin.equals(acctPINs[i]) ){
                pinResult = true;
            }
        }


        if ( (findAcct(acctNums,acctNum) != -1 ) && pinResult ){
            int index = findAcct(acctNums,acctNum);
            atm(acctNames,acctSurnames,acctBalances, index ,new Scanner(System.in));
        }
        else {
            System.out.println("ERROR: Account/PIN combination not found.");
        }

    }


    public static int findAcct(int[] acctNums, int acctNum){
        for (int i = 0 ; i < acctNums.length ; i++){
            if ( acctNum == acctNums[i]){
                return i;
            }
        }
        return -1;
    }


    public static void atm( String[] names , String[] surnames , double[] balances , int index , Scanner input ){

        while (true) {
            System.out.println();
            System.out.println("Hello "+names[index].substring(0,1).toUpperCase()+names[index].substring(1).toLowerCase()+" "+surnames[index].toUpperCase());

            System.out.println("What would you like to do today? ");
            int selection =  menuDisplay(new String[]{"Account Balance",
                            "Deposit",
                            "Withdrawal",
                            "Change Name"},
                    new Scanner(System.in)) ;
            if (selection == 1)
            {
                System.out.println("Your account balance is: " + balances[index] + "\n");
            }
            else if (selection == 2)
            {
                System.out.print("How much are you depositing? ");
                double deposit = input.nextDouble();
                if ( isDepositValid(deposit) )
                {
                    balances[index] += deposit;
                }else
                {
                    System.out.println("ERROR: Invalid deposit amount");
                }
                System.out.println();
            }
            else if (selection == 3)
            {
                System.out.print("How much are you withdrawing? ");
                double withdraw = input.nextDouble();
                if ( isWithdrawalValid(balances[index],withdraw))
                {
                    balances[index] -= withdraw;
                    System.out.println("You will receive the following: ");
                    System.out.println(moneyGiven(withdraw));
                }else
                {
                    System.out.println("ERROR: Invalid withdrawal amount");
                }
                System.out.println();
            }
            else if (selection==4){
                System.out.print("Please enter your name >> ");
                names[index]= input.next();
                System.out.print("Please enter your surname >> ");
                surnames[index]= input.next();
            }
            else if (selection == 0) {
                System.out.println("Thank you for using our ATM. Have a nice day!");
                break;
            }
            else {
                System.out.println("Invalid choice. Exiting System.");
                break;
            }
        }


    }


    public static int menuDisplay(String[] items,Scanner input){

        for (int i= 0 ; i< items.length ; i++){

            System.out.println( (i+1) +" - "+items[i]);

        }
        System.out.println("0 to Quit");
        System.out.print("Please enter your selection >> ");
        int selection = input.nextInt();

        return selection;
    }


    public static boolean isWithdrawalValid(double balance,double amountOfWithdrawn){
        if ( amountOfWithdrawn>0 && amountOfWithdrawn<=balance ){
            return true;
        } else {
            return false;
        }
    }


    public static boolean isDepositValid(double amount){
        if (amount>0){
            return true;
        } else{
            return false;
        }
    }


    public static String moneyGiven(double amount){

        double[] moneys = {200,100,50,20,10,5,1,0.50,0.25,0.10,0.05,0.01};
        String[] moneyS = {"200","100","50","20","10","5","1","0.50","0.25","0.10","0.05","0.01"};
        String output = "";
        int amount2 = (int) (amount*100);
        for (int i = 0; i < moneys.length; i++) {
            int howMuch = amount2/(int)(moneys[i]*100);
            amount2= amount2 % (int)(moneys[i]*100) ;
            output+=howMuch+" - "+moneyS[i]+"\n";
        }
        return output;
    }

}


