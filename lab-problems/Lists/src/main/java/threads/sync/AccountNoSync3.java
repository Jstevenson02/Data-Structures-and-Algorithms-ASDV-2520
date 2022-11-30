/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author jacob
 */
public class AccountNoSync3 {

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

        private static Lock lock = new ReentrantLock();
        private static Condition newDepositCondition = lock.newCondition();
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            lock.lock();
            try {
                balance += amount;
                System.out.println("Deposit " + amount + "\t\t\t\t" + getBalance());
                newDepositCondition.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void withdraw(int amount) {
            lock.lock();
            try {
                while (balance < amount) {
                    System.out.println("\t\t\tWait for a deposit");
                    newDepositCondition.await();
                }

                balance -= amount;
                System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());

            } catch (InterruptedException ex) {
                ex.printStackTrace();

            } finally {
                lock.unlock();
            }
        }
    }
}
