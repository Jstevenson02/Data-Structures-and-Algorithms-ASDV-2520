/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

/**
 *
 * @author jacob
 */
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
            System.out.println("Oh noes! Interrupted!");
        }
    }
}
