package com.bedirhan.undergraduate.CSE101.CSE101T.Fall.Assignments.Assignment04;

import java.io.*;
import java.util.Scanner;

/**
 * @author Bedirhan Tonğ
 * @version 25.12.2021
 */
public class ATM_20200808033 {
    public static void main(String[] args) throws Exception {


        int numOfAccounts = countAccounts(args[0] +"_AccountInfo.txt");
        int[] acctNums = new int[numOfAccounts];
        double[] acctBalances = new double[numOfAccounts];
        String[] acctNames = new String[numOfAccounts];
        String[] acctSurnames = new String[numOfAccounts];

        readAccountInfo(acctNums,acctNames,acctSurnames,acctBalances,args[0] +"_AccountInfo.txt");
        writeAccountInfo(acctNums,acctNames,acctSurnames,acctBalances,args[0] +"_AccountInfoOut.txt");

    }

    public static int countAccounts(String file) throws FileNotFoundException {
        int counter = 0;
        File fObject = new File(file);
        Scanner fileReader = new Scanner(fObject);

        while (fileReader.hasNextLine()){
            fileReader.nextLine();
            counter++;
        }
        return counter;
    }

    public static void readAccountInfo( int[] acctNums,String[] names,String[] surnames,double[] balances,String filename)
            throws Exception {
        File file = new File(filename);
        Scanner fileReader = new Scanner(file);

        for(int i = 0; i < countAccounts(filename); i++) {
            acctNums[i] = Integer.parseInt(fileReader.next());
            names[i] = fileReader.next();
            surnames[i] = fileReader.next();
            balances[i] = Double.parseDouble(fileReader.next());
        }
    }

    public static boolean deposit(double[] balances,int index,double amount){

        if (!(isDepositValid(amount))){
            return false;
        }
        else{
            balances[index] += amount;
            return true;
        }

    }

    public static boolean withdrawal(double[] balances,int index,double amount){

        if (isWithdrawalValid(balances[index],amount)){
            balances[index] -= amount;
            return true;
        }
        else{
            return false;
        }
    }

    public static int transfer(int[] acctNums ,double[] balances,int acctNumFrom, int acctNumTo,double amount){

        if (!(findAcct(acctNums,acctNumFrom) < 0 )){
            if (!(findAcct(acctNums,acctNumTo) < 0 ) ){
                if (isWithdrawalValid(balances[findAcct(acctNums,acctNumFrom)],amount)){
                    withdrawal(balances,findAcct(acctNums,acctNumFrom),amount);
                    deposit(balances,findAcct(acctNums,acctNumTo),amount);
                    return 0;
                }
                else
                    return 3 ;
            }
            else {
                return 1;
            }
        }
        else{
            return 2;
        }

    }

    public static void writeAccountInfo(int[] acctNums,String[] names,String[] surnames,double[] balances,
                                        String filename) throws IOException {

        String baseFileName = filename.substring(0,filename.lastIndexOf("_"));
        String accInfo = (baseFileName+"_AccountInfo.txt");
        int countAcc = countAccounts(accInfo);
        File fileOfTransfers = new File(baseFileName+"_TransferInfo.txt");

        String[] numOfTrans = new String[countAcc];
        int[] acctsFrom = new int[countAcc];
        int[] acctsTo = new int[countAcc];
        double[] amountOfTrans = new double[countAcc];

        Scanner readFile;
        try {
            readFile = new Scanner(fileOfTransfers);

            for(int i = 0; i < countAccounts(baseFileName + "_TransferInfo.txt"); i++) {
                numOfTrans[i] = readFile.next();
                acctsFrom[i] = readFile.nextInt();
                acctsTo[i] = readFile.nextInt();
                amountOfTrans[i] = Double.parseDouble(readFile.next());
            }
            File logFile = new File(baseFileName + ".log");
            FileWriter fWriter = new FileWriter(logFile);

            for(int i = 0; i <countAccounts(baseFileName + "_TransferInfo.txt"); i++) {
                int codeOfTransfer = transfer(acctNums, balances, acctsFrom[i],
                        acctsTo[i], amountOfTrans[i]);

                fWriter.write("Transfer " + numOfTrans[i] + " resulted in code " + codeOfTransfer);
                switch (codeOfTransfer) {
                    case 0: {
                        fWriter.write(": STX - Transfer Successful\n");
                        break;
                    }
                    case 1: {
                        fWriter.write(": TNF - To Account not found\n");
                        break;
                    }
                    case 2: {
                        fWriter.write(": FNF - From Account not found\n");
                        break;
                    }
                    case 3: {
                        fWriter.write(": NSF - Insufficient Funds\n");
                        break;
                    }
                    default:
                        throw new IllegalArgumentException("Unexpected value: " + codeOfTransfer);
                }
            }

            File f2 = new File(baseFileName + "_AccountInfoOut.txt");
            FileWriter fileWriter2 = new FileWriter(f2);
            for(int i = 0; i < countAcc; i++) {

                fileWriter2.write(acctNums[i] + " ");
                fileWriter2.write(names[i] + " ");
                fileWriter2.write(surnames[i] + " ");
                fileWriter2.write(balances[i] + "");
                fileWriter2.write("\n");

            }
            fWriter.close();
            fileWriter2.close();

        } catch (Exception ignored) {
        }

    }

    public static int findAcct(int[] acctNums, int acctNum){
        int returnValue = -1;
        for (int i = 0 ; i < acctNums.length ; i++){
            if (  acctNums[i] == acctNum){
                returnValue = i;
            }
        }
        return returnValue;
    }

    public static boolean isWithdrawalValid(double balance,double amountOfWithdrawn){
        if ( amountOfWithdrawn>0 && amountOfWithdrawn <= balance ){
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDepositValid(double amount){
        return amount > 0;
    }



}
