package com.atm;

import java.util.ArrayList;

public class Main {

        public static void main(String[] args) {
                ATM atm = new ATM();
                Client client = new Client();
                Client client1 = new Client();
            CurrentThread thread = new CurrentThread(atm);
            Thread thread1 = new Thread(thread);
            thread1.start();

            ArrayList<Client> clientService = new ArrayList<>();
                clientService.add(client);
                clientService.add(new Client());
                clientService.add(new Client());
                clientService.add(new Client());
                clientService.add(client1);
            try {
                for (Client c : clientService) {
                    //new CurrentThread(c);
                    Thread thread2 = new Thread(new CurrentThread(c));
                    thread2.start();
                }
            } catch (Exception e){
            System.out.println("you have been input incorrect command");
                }
                ATM.getReport();
    }
}
class Client extends ATM{}

