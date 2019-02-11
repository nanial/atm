package com.atm;

public class CurrentThread implements Runnable {
    ATM atm = new ATM();

    public CurrentThread(ATM atm) {
        this.atm = atm;
    }


    @Override
    public void run() {

        try {
            atm.service();
        }catch (Exception io){
            System.out.println(io.toString());
        }
    }

}
