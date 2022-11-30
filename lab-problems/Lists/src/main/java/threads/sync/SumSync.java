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
public class SumSync {

    static int sum = 0;

    synchronized void addSum(int sum) {
        this.sum += sum;
    }

    class AccessSum implements Runnable {

        @Override
        public void run() {
            addSum(1);
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        SumSync ss = new SumSync();
        // Create and launch 100 threads
        for (int i = 0; i < 1000; i++) {
            executor.execute(ss.new AccessSum());
        }
        executor.shutdown();

        while (!executor.isTerminated()) {
        }

        System.out.println("Waited... What is balance? " + ss.sum);

    }
}
