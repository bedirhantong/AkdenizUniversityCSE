package com.bedirhan.undergraduate.CSE102.CSE102T.Assignment01;

/**
 * @author Bedirhan Tonğ
 * @date 14.03.2022
 */
public class Assignment01_20200808033 {
    public static void main(String[] args) {

    }
}

class Account{
    private final String acctNum;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.acctNum = accountNumber;
        if (balance < 0 )
            this.balance = 0;
        else
            this.balance = balance;
    }
    public Account(String accountNumber) {
        this.acctNum = accountNumber;
        this.balance = 0;
    }

    public void deposit(double amount){
        if (amount>0)
            this.balance += amount;
    }
    public void withdrawal(double amount){
        if(amount > 0){
            this.balance -= amount;
        }
    }

    @Override
    public String toString() {
        return "Account "+ acctNum +" has " + balance;
    }


    public String getAcctNum() {
        return acctNum;
    }

    public double getBalance() {
        return balance;
    }

}

class PersonalAccount extends Account{

    private String name;
    private String surName;
    private String pin;

    public PersonalAccount(String accountNumber, String name, String surName, double balance) {
        super(accountNumber, balance);
        this.name = name;
        this.surName = surName;
        setPin((String.valueOf((int) (Math.random() * 10))));
        this.pin+=(String.valueOf((int) (Math.random() * 10)));
        this.pin+=(String.valueOf((int) (Math.random() * 10)));
        this.pin+=(String.valueOf((int) (Math.random() * 10)));

    }

    public PersonalAccount(String accountNumber, String name, String surName) {
        super(accountNumber);
        this.name = name;
        this.surName = surName;
        setPin((String.valueOf((int) (Math.random() * 10))));
        this.pin+=(String.valueOf((int) (Math.random() * 10)));
        this.pin+=(String.valueOf((int) (Math.random() * 10)));
        this.pin+=(String.valueOf((int) (Math.random() * 10)));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    @Override
    public String toString(){
        return "Account " +getAcctNum()+" belonging to "
                +name+" "+surName.toUpperCase()+" has "
                +getBalance();
    }

}

class BusinessAccount extends Account{
    private double rate;
    public BusinessAccount(String accountNumber, double balance, double rate) {
        super(accountNumber, balance);
        this.rate = rate;
    }

    public BusinessAccount(String accountNumber, double rate) {
        super(accountNumber);
        this.rate = rate;
    }

    public double calculateInterest(){
        return getRate()*getBalance();
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

}

class Customer{

    private String name;
    private String surName;
    private PersonalAccount personalAccount;

    public Customer(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public void openAccount(String acctNum){
        personalAccount = new PersonalAccount(acctNum,this.name,this.surName,0);
    }
    public PersonalAccount getAccount(){
        return personalAccount;
    }


    public String toString(){
        return getName()+" "+getSurName().toUpperCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }



}

class Company{
    private String name;
    private BusinessAccount businessAccount;

    public Company(String name) {
        this.name = name;
    }

    public void openAccount(String acctNum,double rate){
        businessAccount = new BusinessAccount(acctNum,0,rate);
    }

    public BusinessAccount getAccount(){
        return businessAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return getName();
    }


}

