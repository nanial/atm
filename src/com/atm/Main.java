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
            try {
                    thread1.join(500);
            }catch (InterruptedException io){
                System.out.println("Thread have been interrupted");
            }

            ArrayList<Client> clientService = new ArrayList<>();
                clientService.add(client);
                clientService.add(new Client());
                clientService.add(new Client());
                clientService.add(new Client());
                clientService.add(client1);
            try {
                for (Client c : clientService) {
                    Thread thread2 = new Thread(new CurrentThread(atm));
                    thread2.start();
                    thread2.join(5000);
                }
            } catch (Exception e){
            System.out.println("you have been input incorrect command");
                }
                ATM.getReport();
    }
}
class Client extends ATM{}

