/*
 * Author: Kartik Gola
 * Date: 1/15/22, 10:35 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package concurrency.liveness;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Starvation {

    private static void example1() {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService es = Executors.newFixedThreadPool(cores);
        try {

            Object monitor = new Object();
            Thread[] threads = new Thread[cores];

            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(){
                    int iter = 0;
                    @Override
                    public void run() {
                        while (true) {
                            if (Thread.currentThread().isInterrupted()) {
                                System.out.println(Thread.currentThread() + " iterations = " + iter);
                                return;
                            }
                            // Since there is only 1 monitor, it may so happen that a thread repeatedly gets the lock
                            // and performs its operation (incrementing iter in this case), while starving the other threads
                            synchronized (monitor) {
                                iter++;
                            }
                        }
                    }
                };
                es.execute(threads[i]);
            }

            // shutdown and wait for 2s
            es.shutdown();
            Thread.sleep(2000);

            // Interrupt the running threads
            es.shutdownNow();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static void main(String[] args) {
        example1();
    }
}
