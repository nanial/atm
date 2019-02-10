package com.atm;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Account {
    int id;
    String accountNum;
    private double balance;
    final private double maxWithdraw = 1000;
    final private double maxDeposit = 1000;//input money
    static HashMap<String, String> cardInfo = new HashMap<>();
    static Map<String, Account> accountMap = new TreeMap<>();

    Account(){

    }
    Account(String accountNumNum, double balance, int id){
        this.accountNum = accountNumNum;
        this.balance = balance;
        this.id = id;
    }
    static void base(){
        cardInfo.put("123456789", "3258");
        cardInfo.put("147896325", "1478");
        cardInfo.put("147854123", "1452");
        cardInfo.put("147946190", "1475");


        accountMap.put("123456789", new Account("BY102947565", 15000, 1));
        accountMap.put("147896325", new Account("BY210293930", 25000, 2));
        accountMap.put("147854123", new Account("BY393983833", 185000, 3));
        accountMap.put("147946190", new Account("BY203839339", 20000, 4));

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance){

        this.balance = balance;
    }

    public double deposit(double amountOfDeposit) {
        if(amountOfDeposit <= maxDeposit){
            balance += amountOfDeposit;
            System.out.println("your balance is " + balance);
            setBalance(balance);
        }
        else
            System.out.println("you have exceeded the allowable amount");
        return balance;

    }

    public double withdraw(double amountOfWithdraw){
        if (amountOfWithdraw <= maxWithdraw && amountOfWithdraw <= balance){
            balance -= amountOfWithdraw;
            System.out.println("your balance is " + getBalance());
            setBalance(balance);
        }
        else
            System.out.println("you have exceeded the allowable amount");
        return balance;
    }

    @Override
    public String toString() {
        return  "accountNum is " + accountNum  + ", balance is " + balance;
    }

}