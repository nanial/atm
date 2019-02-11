package com.atm;

public class Account {
    int id;
    String accountNum;
    private double balance;
    final private double maxWithdraw = 1000;
    final private double maxDeposit = 1000;//input money


    Account(String accountNumNum, double balance, int id){
        this.accountNum = accountNumNum;
        this.balance = balance;
        this.id = id;
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