package com.atm;

import java.util.*;

 class ATM  {
   private static HashMap<String, String> cardInfo = new HashMap<>();
    private static Map<String, Account> accountMap = new TreeMap<>();
    private static ArrayList <String> report = new ArrayList<>();


    public ATM() {
        base();
    }

    private static void base(){
        cardInfo.put("123456789", "3258");
        cardInfo.put("147896325", "1478");
        cardInfo.put("147854123", "1452");
        cardInfo.put("147946190", "1475");
        cardInfo.put("111111111", "1111");

        accountMap.put("123456789", new Account("BY102947565", 15000, 1));
        accountMap.put("147896325", new Account("BY210293930", 25000, 2));
        accountMap.put("147854123", new Account("BY393983833", 185000, 3));
        accountMap.put("147946190", new Account("BY203839339", 20000, 4));

        }

     void service()  {
        synchronized (this) {

            System.out.println("/////////////////////////////////////////////////////////////////");
            System.out.println("For admin press 1, for clients 2, for course of currency 3");

            int mainMenu = new Scanner(System.in).nextInt();
            if (mainMenu == 2) {
                System.out.println("Input number of credit card");

                String creditCardNum = new Scanner(System.in).nextLine();
                System.out.println("Input pin-code");
                String pin = new Scanner(System.in).nextLine();

                if (cardInfo.containsKey(creditCardNum)) {
                    if (cardInfo.get(creditCardNum).equals(pin)) {
                        System.out.println("Input 1 for balance, 2 for withdraw, 3 for deposit 4 for exit");

                        long begin = System.currentTimeMillis();
                        int choice = new Scanner(System.in).nextInt();
                        report.add("creditCard " + creditCardNum + " transactions are:");

                        one:
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
                                    System.out.println("input amount of withdraw" + "\n" +
                                            " amount must be a multiple of 5");
                                    double amount = new Scanner(System.in).nextDouble();
                                    if (amount %5 == 0) {
                                    accountMap.get(creditCardNum).withdraw(amount);
                                    }else System.out.println("amount must be a multiple of 5");
                                    System.out.println("Choice next operation");
                                    choice = new Scanner(System.in).nextInt();
                                    break;
                                case 3:
                                    report.add(" " + choice + ",");
                                    System.out.println("input amount of deposit, please" + "\n" +
                                            "amount must be a multiple of 5");
                                    double amount1 = new Scanner(System.in).nextDouble();
                                    if (amount1 %5 == 0) {
                                        accountMap.get(creditCardNum).deposit(amount1);
                                    }else System.out.println(" amount must be a multiple of 5");
                                    System.out.println("Choice next operation");
                                    choice = new Scanner(System.in).nextInt();
                                    break;
                                default:
                                    System.out.println("You have been incorrect command");
                                    break one;

                            }
                        }
                        System.out.println("take your card");
                        System.out.println("/////////////////////////////////////////////////////////////////");

                        long time = System.currentTimeMillis() - begin;
                        report.add(Thread.currentThread().getName() + " spent time " + time + " ms " + "\n" );

                    } else {
                        System.out.println("incorrect pin-code");
                    }
                }
            } else if (mainMenu == 1) {
                System.out.println("Input number of credit card");

                String creditCardNum = new Scanner(System.in).nextLine();
                System.out.println("Input pin-code");
                String pin = new Scanner(System.in).nextLine();

                if (cardInfo.containsKey(creditCardNum)) {
                    if (cardInfo.get(creditCardNum).equals(pin)) {
                        ATM.getReport();

                    }
                }
            }
            else if (mainMenu == 3){
                CourseOfCurrency.getCourse();
            }
        }
    }
    public static ArrayList<String> getReport() {
        for (String s: report) {
            System.out.print(s);

        }
        return report;
    }
}



