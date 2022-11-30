/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

/**
 *
 * @author jacob
 */
public class Threads1 {

    public static void main(String[] args) {
        // Create tasks
        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);

        // Create threads
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class PrintChar implements Runnable {

    private char charToPrint;
    private int times;

    public PrintChar(char c, int t) {
        charToPrint = c;
        times = t;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println(charToPrint);
        }
    }
}

class PrintNum implements Runnable {

    private int lastNum;

    public PrintNum(int n) {
        lastNum = n;
    }

    @Override
    public void run() {

        Thread thread4 = new Thread(new PrintChar('c', 40));
        thread4.start();
        try {
            for (int i = 1; i <= lastNum; i++) {
                System.out.println(" " + i);
                if (i == 50) {
                    thread4.join();
                }
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

    public void run1() {
        for (int i = 1; i <= lastNum; i++) {
            System.out.println(" " + i);
            //Thread.yield();
            try {
                if (i >= 50) {
                    Thread.sleep(1);
                }
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
}
