package com.atm;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

        public static void main(String[] args) {
                ATM atm = new ATM();
            ArrayList<ATM> clientService = new ArrayList<>();
                clientService.add(new ATM());

            try {
                Iterator iterator = clientService.iterator();
                Thread thread = null;
                for (int i = 0; i < 2; i++){
                    thread = new Thread(new CurrentThread(atm));
                    thread.start();
                }
                thread.join();

            } catch (Exception e){
            System.out.println("you have been input incorrect command");
                }

                ATM.getReport();
        }
}


