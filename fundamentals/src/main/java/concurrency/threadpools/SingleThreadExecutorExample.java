/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package concurrency.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample {

    private static final Runnable countingTask = () -> {
        for (int i = 0; i < 5; ++i) {
            System.out.println(Thread.currentThread().getName() + " running " + i);
            try {
                // Simulating heavy-work
                Thread.sleep(100);
            } catch (InterruptedException interruptedException) {
                System.out.println(Thread.currentThread().getName() + " interrupted. Exiting...");
                return;
            }
        }
    };

    public static void singleThreadPool() {
        ExecutorService es = Executors.newSingleThreadExecutor();
        try {
            // Order of execution of these tasks IS guaranteed if there is only a single thread
            es.execute(countingTask);
            es.execute(countingTask);
            es.execute(countingTask);
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            es.shutdown();
        }
    }

    public static void main(String[] args) {
        singleThreadPool();
    }
}
