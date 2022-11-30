/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import java.util.concurrent.*;

/**
 *
 * @author jacob
 */
public class ExecutionerDemo {

    public static void main(String[] args) {

        // Create a fixed thread pool with a maximum of three threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit runnable tasks to the executor
        executor.execute(new PrintChar('a', 100));
        executor.execute(new PrintChar('b', 100));
        executor.execute(new PrintNum(100));
        
        // Shutdown the executor
        executor.shutdown();
    }
}
