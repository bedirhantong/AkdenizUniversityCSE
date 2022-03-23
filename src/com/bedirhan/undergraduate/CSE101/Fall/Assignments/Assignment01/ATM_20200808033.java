package com.bedirhan.undergraduate.CSE101.Fall.Assignments.Assignment01;

/**
 * @author Bedirhan ( 20200808033 )
 * @version 11.10.2021
 */

import java.util.Scanner;

public class ATM_20200808033 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        String endMessage= "Have a nice day.";

        System.out.print("Please enter the balance : ");
        double totalBalance = input.nextDouble();
        if ( totalBalance<0 )
        {
            System.out.println("ERROR: Invalid deposit amount");
        } else{

            System.out.println("What would you like to do today? ");
            System.out.println("1 for Balance \n2 for Deposit");
            System.out.println("3 for Withdrawal \n0 to quit");
            System.out.print("Please enter your selection: ");
            int selection= input.nextInt();

            if( selection == 1 )
            {
                System.out.println("The current balance is "+totalBalance);
                System.out.println(endMessage);
            }
            else if ( selection == 2 )
            {
                System.out.print("Please enter the amount to deposit: ");
                int deposit = input.nextInt();
                if (deposit<0)
                {
                    System.out.println("ERROR: Invalid deposit amount");
                }
                else
                {
                    totalBalance+=deposit;
                }

                System.out.println("The current balance is "+totalBalance);
                System.out.println(endMessage);
            }
            else if ( selection== 3 )
            {
                System.out.print("Please enter the ammount to withdraw: ");
                int withdraw = input.nextInt();

                if( withdraw > totalBalance ){
                    System.out.println("ERROR: Invalid withdraw amount");
                }
                else {
                    if (withdraw<0)
                    {
                        System.out.println("ERROR: Invalid withdraw amount");
                    }
                    else
                    {
                        totalBalance-=withdraw;
                    }
                    System.out.println("The current balance is "+totalBalance);
                    System.out.println(endMessage);
                }

            }
            else if ( selection== 0 ) {
                System.out.println("");
            }
            else
            {
                System.out.println("ERROR: Invalid selection. Exiting System.");
            }

        }
    }
}

