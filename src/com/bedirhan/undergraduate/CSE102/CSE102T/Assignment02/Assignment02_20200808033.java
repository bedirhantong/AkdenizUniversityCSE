package com.bedirhan.undergraduate.CSE102.CSE102T.Assignment02;
import java.util.ArrayList;
import java.util.StringJoiner;
/**
 * @author 20200808033 Bedirhan Tonğ
 * @date 06.04.2022
 */


public class Assignment02_20200808033 {
    public static void main(String[] args) {
        Bank b = new Bank("My Bank", "My Bank's Address");
        b.addCompany(1, "Company 1");
        b.getCompany(1).openAccount("1234", 0.05);
        b.addAccount(b.getCompany(1).getAccount("1234"));
        b.getAccount("1234").deposit(500000);
        b.getCompany(1).getAccount("1234").deposit(500000);
        b.getCompany(1).openAccount("1235", 0.03);
        b.addAccount(b.getCompany(1).getAccount("1235"));
        b.getCompany(1).getAccount("1235").deposit(25000);
        b.addCompany(2, "Company 2");
        b.getCompany(2).openAccount("2345", 0.03);
        b.addAccount(b.getCompany(2).getAccount("2345"));
        b.getCompany(2).getAccount("2345").deposit(350);
        b.addCustomer(1, "Customer 1","1");
        b.addCustomer(2, "Customer 2","2");
        Customer c = b.getCustomer(1);
        c.openAccount("3456");
        c.openAccount("3457");
        c.getAccount("3456").deposit(150);
        c.getAccount("3457").deposit(250);
        c = b.getCustomer(2);
        c.openAccount("4567");
        c.getAccount("4567").deposit(1000);
        b.addAccount(c.getAccount("4567"));
        c = b.getCustomer(1);
        b.addAccount(c.getAccount("3456"));
        b.addAccount(c.getAccount("3457"));
        System.out.println(b.toString());
    }
}
class Bank{
    String name;
    String address;
    ArrayList<Customer> customers;
    ArrayList<Company> companies;
    ArrayList<Account> accounts;
    private int indexOfAccount;
    private int indexOfCustomer;
    private int indexOfCompany;

    public Bank(String name,String address){
        setName(name);
        setAddress(address);
        customers = new ArrayList<>();
        companies = new ArrayList<>();
        accounts = new ArrayList<>();
    }
    private String printCompanies(){
        StringJoiner stringJoiner = new StringJoiner("");

        for (Company company : companies) {
            stringJoiner.add("  " + company.getName() + "\n");
            for (int j = 0; j < company.businessAccounts.size(); j++) {
                stringJoiner.add("      " + company.businessAccounts.get(j).getAcctNum() + "   ");
                stringJoiner.add((company.businessAccounts.get(j).getRate()) + "  ");
                stringJoiner.add(company.businessAccounts.get(j).getBalance() + "\n");
            }
        }
        return stringJoiner.toString();
    }
    private String printCustomers(){
        StringJoiner stringJoiner = new StringJoiner("");

        for (int i = 0; i < customers.size(); i++) {
            stringJoiner.add("  "+customers.get(i).getName()+"\n");
            for (int j = 0; j < companies.get(i).businessAccounts.size(); j++) {
                stringJoiner.add("      "+customers.get(i).personalAccounts.get(j).getAcctNum()+"   ");
                stringJoiner.add(customers.get(i).personalAccounts.get(j).getBalance()+"\n");
            }
        }
        return stringJoiner.toString();
    }


    @Override
    public String toString() {
        return name+"   "+address+"\n"+
                printCompanies()+printCustomers();
    }


    public void closeAccount(String accountNum){
        if (isContainsAccount(accountNum)){
            setIndexOfAccount(accountNum);
            if (accounts.get(indexOfAccount).getBalance()>0){
                throw new BalanceRemainingException(accounts.get(indexOfAccount).getBalance());
            }
            else {
                accounts.remove(indexOfAccount);
            }
        }
        else{
            throw new AccountNotFoundException(accountNum);
        }
    }

    public boolean isValidAmount(double amount,String accountFrom){
        setIndexOfAccount(accountFrom);
        return (amount > 0) && (accounts.get(indexOfAccount).getBalance()>=amount) ;
    }
    public void transferFunds(String accountFrom,String accountTo,double amount){
        if (isContainsAccount(accountFrom)){
            if (isContainsAccount(accountTo)){
                if (isValidAmount(amount,accountFrom)){
                    setIndexOfAccount(accountFrom);
                    accounts.get(indexOfAccount).withdrawal(amount);
                    setIndexOfAccount(accountTo);
                    accounts.get(indexOfAccount).deposit(amount);
                }
                else{
                    throw  new InvalidAmountException(amount);
                }
            }
            else{
                throw new AccountNotFoundException(accountTo);
            }
        }
        else{
            throw new AccountNotFoundException(accountFrom);
        }
    }

    public boolean isContainsAccount(String accountNum){
        for (Account account : accounts) {
            if (account.getAcctNum().equals(accountNum) ){
                return true;
            }
        }
        return false;
    }
    public void setIndexOfAccount(String accountNum){
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAcctNum().equals(accountNum)){
                indexOfAccount = i ;
            }
        }
    }
    public Account getAccount(String accountNum){
        if (isContainsAccount(accountNum)){
            setIndexOfAccount(accountNum);
            return accounts.get(indexOfAccount);
        }
        else {
            throw new AccountNotFoundException(accountNum);
        }
    }


    public boolean isContainsCompany(String name){
        for (Company company : companies) {
            if (company.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public void setIndexOfCompany(String name){
        for (int i = 0; i < companies.size(); i++) {
            if (companies.get(i).getName().equals(name)){
                indexOfCompany = i ;
            }
        }
    }
    public Company getCompany(String name){
        if (isContainsCompany(name)){
            setIndexOfCompany(name);
            return companies.get(indexOfCompany);
        }
        else {
            throw new CompanyNotFoundException(name);
        }
    }

    public boolean isContainsCompany(int id){
        for (Company company : companies) {
            if (company.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public void setIndexOfCompany(int id){
        for (int i = 0; i < companies.size(); i++) {
            if (companies.get(i).getId() == id){
                indexOfCompany = i ;
            }
        }
    }
    public Company getCompany(int id){
        if (isContainsCompany(id)){
            setIndexOfCompany(id);
            return companies.get(indexOfCompany);
        }
        else {
            throw new CompanyNotFoundException(id);
        }
    }

    public boolean isContainsCustomer(String name,String surname){
        for (Customer customer : customers) {
            if (customer.getName().equals(name) && customer.getSurname().equals(surname) ) {
                return true;
            }
        }
        return false;
    }
    public void setIndexOfCustomer(String name,String surname){
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name) && customers.get(i).getSurname().equals(surname) ){
                indexOfCustomer = i ;
            }
        }
    }
    public Customer getCustomer(String name,String surname){
        if (isContainsCustomer(name,surname)){
            setIndexOfCustomer(name,surname);
            return customers.get(indexOfCustomer);
        }
        else
            throw new CustomerNotFoundException(name,surname);
    }
    public Customer getCustomer(int id){
        if (isContainsCustomer(id)){
            setIndexOfCustomer(id);
            return customers.get(indexOfCustomer);
        }
        else
            throw new CustomerNotFoundException(id);
    }

    public void setIndexOfCustomer(int id){
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id){
                indexOfCustomer = i ;
            }
        }
    }

    public boolean isContainsCustomer(int id){
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public void addAccount(Account account){
        accounts.add(account);
    }

    public void addCompany(int id,String name){
        Company company = new Company(id,name);
        company.setId(id);
        companies.add(company);
    }

    public void addCustomer(int id,String name,String surname){
        Customer customer = new Customer(id,name, surname);
        customers.add(customer);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
class Account{
    private final String acctNum;
    private double balance;


    public Account(String accountNumber, double balance) {
        this.acctNum = accountNumber;
        if (balance < 0) {
            throw new IllegalArgumentException();
        }
        else{
            this.balance = balance;
        }

    }
    public Account(String accountNumber) {
        this.acctNum = accountNumber;
        this.balance = 0;
    }

    public void deposit(double amount){
        if (amount>=0)
            this.balance += amount;
        else{
            throw new InvalidAmountException(amount);
        }
    }
    public void withdrawal(double amount){
        if(  (amount >= 0)  && getBalance()>= amount){
            this.balance -= amount;
        }
        else if (amount<0 || (getBalance() < amount)){
            throw new InvalidAmountException(amount);
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
        setRate(rate);
    }

    public BusinessAccount(String accountNumber, double rate) {
        super(accountNumber);
        setRate(rate);
    }

    public double calculateInterest(){
        return getRate()*getBalance();
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        if (rate <= 0){
            throw new IllegalArgumentException();
        }
        else {
            this.rate = rate;
        }
    }

}
class Customer{
    int id;
    String name;
    String surname;
    ArrayList<PersonalAccount> personalAccounts;
    int indexOfAccountNum;

    public Customer(int id,String name, String surname) {
        setId(id);
        this.name = name;
        this.surname = surname;
        personalAccounts = new ArrayList<>();
    }
    public void addAccount(PersonalAccount personalAccount){
        personalAccounts.add(personalAccount);
    }

    public boolean isContains (String accountNum){
        for(PersonalAccount personalAccount: personalAccounts){
            if (personalAccount.getAcctNum().equals(accountNum)){
                return true;
            }
        }
        return false;
    }
    public void setIndexOfAccountNum(String accountNum){
        for (int j = 0; j < personalAccounts.size(); j++) {
            if (personalAccounts.get(j).getAcctNum().equals(accountNum)){
                indexOfAccountNum = j;
            }
        }
    }

    public void openAccount(String acctNum){
        PersonalAccount personalAccount = new PersonalAccount(acctNum,this.name,this.surname);
        addAccount(personalAccount);
    }

    public PersonalAccount getAccount(String accountNum){
        if (isContains(accountNum)){
            setIndexOfAccountNum(accountNum);
            return personalAccounts.get(indexOfAccountNum);
        }
        else {
            throw new AccountNotFoundException(accountNum);
        }
    }

    public void closeAccount(String accountNum){
        if (isContains(accountNum)){
            setIndexOfAccountNum(accountNum);
            if (personalAccounts.get(indexOfAccountNum).getBalance() > 0){
                throw new BalanceRemainingException(personalAccounts.get(indexOfAccountNum).getBalance());
            }
            else {
                personalAccounts.remove(indexOfAccountNum);
            }
        }
        else{
            throw new AccountNotFoundException(accountNum);
        }
    }

    public String toString(){
        return getName()+" "+getSurname().toUpperCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurName(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0){
            throw new IllegalArgumentException();
        }
        else{
            this.id = id;
        }
    }

}
class Company{
    int id;
    String name;
    ArrayList<BusinessAccount> businessAccounts;
    int indexOfAccountNum;

    public Company(int id,String name) {
        setId(id);
        setName(name);
        businessAccounts = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0){
            this.id = id;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void openAccount(String acctNum, double rate){
        BusinessAccount businessAccount = new BusinessAccount(acctNum,rate);
        businessAccounts.add(businessAccount);
    }


    public boolean isContains(String acctNum){
        for (BusinessAccount businessAccount : businessAccounts) {
            if (businessAccount.getAcctNum().equals(acctNum)) {
                return true;
            }
        }
        return false;
    }
    public void setIndexOfAccountNum(String acctNum){
        for (int i = 0; i < businessAccounts.size(); i++) {
            if (businessAccounts.get(i).getAcctNum().equals(acctNum)){
                indexOfAccountNum = i;
            }
        }
    }
    public BusinessAccount getAccount(String acctNum){
        if (isContains(acctNum)){
            setIndexOfAccountNum(acctNum);
            return businessAccounts.get(indexOfAccountNum);
        }
        else{
            throw new AccountNotFoundException(acctNum);
        }
    }

    public void closeAccount(String accountNum){

        if (isContains(accountNum)){
            setIndexOfAccountNum(accountNum);
            businessAccounts.remove(indexOfAccountNum);
        }
        else{
            throw new AccountNotFoundException(accountNum);
        }
    }

}

class AccountNotFoundException extends RuntimeException{
    String acctNum;
    public AccountNotFoundException(String acctNum){
        this.acctNum= acctNum;
    }

    @Override
    public String toString() {
        return "AccountNotFoundException: " + acctNum;
    }
}
class BalanceRemainingException extends RuntimeException{
    double balance;

    public double getBalance() {
        return this.balance;
    }
    public BalanceRemainingException(double balance){
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BalanceRemainingException: "+ getBalance();
    }
}
class CompanyNotFoundException extends RuntimeException{
    int id;
    String name;
    private int settingId = 1;
    public CompanyNotFoundException(int id){
        this.id= id;
        this.name = null;
    }
    public CompanyNotFoundException(String name){
        this.name= name;
        setId();
    }
    public void setId(){
        this.id = settingId;
        settingId++;
    }


    @Override
    public String toString() {
        if (this.name != null){
            return "CompanyNotFoundException: name - "+name;
        }
        return "CompanyNotFoundException: id - "+id;
    }
}
class CustomerNotFoundException extends RuntimeException{
    int id;
    String name;
    String surname;
    private int settingId = 1;
    public CustomerNotFoundException(int id){
        this.id = id;
        this.name = null;
        this.surname = null;
    }
    public CustomerNotFoundException(String name,String surname){
        this.name = name;
        this.surname = surname;
        setIdToSettingId();
    }
    public void setIdToSettingId(){
        this.id = settingId;
        settingId++;
    }
    @Override
    public String toString() {
        if (name != null || surname!= null ){
            return "CustomerNotFoundException: name - "+name+" "+surname;
        }
        return "CustomerNotFoundException: id -"+id;
    }
}
class InvalidAmountException extends RuntimeException{
    double amount;
    public InvalidAmountException (double amount){
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "InvalidAmountException: "+ amount;
    }
}