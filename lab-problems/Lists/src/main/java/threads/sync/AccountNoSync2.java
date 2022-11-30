/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author jacob
 */
public class AccountNoSync2 {

    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        // Create and launch 100 threads
        for (int i = 0; i < 100; i++) {
            executor.execute(new AddAPennyTask());
        }
        executor.shutdown();

        if (executor.isTerminated()) {
            System.out.println("What is the balance? " + account.getBalance());
        } else {
            while (!executor.isTerminated()) {
            }
            System.out.println("Waited... What is balance? " + account.getBalance());
        }

    }

    private static class AddAPennyTask implements Runnable {

        @Override
        public void run() {
            synchronized (account) {

                account.deposit(1);
            }
        }
    }

    private static class Account {

        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {

            int newBalance = balance + amount;

            try {
                Thread.sleep(5);

            } catch (InterruptedException ex) {
            }
            balance = newBalance;
        }
    }
}
