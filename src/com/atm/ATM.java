package com.atm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ATM extends Account {
    static ArrayList <String> report = new ArrayList<>();

    public ATM() {
    }

    public  void service() throws IOException {
        base();
        synchronized (this) {
            System.out.println("Input number of credit card");
            String creditCardNum = new Scanner(System.in).nextLine();
            System.out.println("Input pin-code");
            String pin = new Scanner(System.in).nextLine();

            if (cardInfo.containsKey(creditCardNum)) {
                if (cardInfo.get(creditCardNum).equals(pin)) {
                    System.out.println("Input 1 for balance, 2 for withdraw, 3 for deposit 4 for exit");
                   /* CurrentThread thread = new CurrentThread();
                    Thread thread1 = new Thread(thread);
                    thread1.start();
                   */ long begin = System.currentTimeMillis();
                    int choice = new Scanner(System.in).nextInt();
                    report.add("creditCard " + creditCardNum + " transactions are:");

                    while (choice != 4) {
                        switch (choice) {
                            case 1:
                                report.add(" " + choice + ",");
                                System.out.println(accountMap.get(creditCardNum).getBalance());
                                System.out.println("Choice next operation");
                                choice = new Scanner(System.in).nextInt();
                                break;
                            case 2:
                                report.add(" " + choice + ",");
                                System.out.println("input amount of withdraw");
                                accountMap.get(creditCardNum).withdraw(new Scanner(System.in).nextDouble());
                                System.out.println("Choice next operation");
                                choice = new Scanner(System.in).nextInt();
                                break;
                            case 3:
                                report.add(" " + choice + ",");
                                System.out.println("input amount of deposit, please");
                                double amount = new Scanner(System.in).nextDouble();
                                accountMap.get(creditCardNum).deposit(amount);
                                System.out.println("Choice next operation");
                                choice = new Scanner(System.in).nextInt();
                                break;
                            default:
                                System.out.println("You have been incorrect command");
                                System.exit(0);//// need correction
                        }
                    }
                    System.out.println("take your card");
                    System.out.println("//////////////////////////////////////////////////////");
                    // System.exit(0);
                    long time = System.currentTimeMillis() - begin;
                    /*report.add(thread1.getName() + " spent time " + time + " ms " + "%n");
                    try {
                        thread1.join(5000);
                    } catch (InterruptedException ie) {
                        System.out.println("Thread has been interrupted");
                    }*/
                } else {
                    System.out.println("incorrect pin-code");
                }
            }
        }
    }
    public static ArrayList<String> getReport() {
        for (String s: report) {
            System.out.printf(s);

        }
        return report;
    }
}



