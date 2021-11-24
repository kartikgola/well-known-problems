/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package fundamentals.concurrency.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {

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

    public static void shutdownNow() {
        ExecutorService es = Executors.newFixedThreadPool(2);
        try {
            // Order of execution of these 3 tasks in not guaranteed.
            es.execute(countingTask);
            es.execute(countingTask);
            es.execute(countingTask);

            // shutdownNow() will
            // 1. try to interrupt the thread via Thread.interrupt()
            // 2. stop accepting further executions
            // However, it is up to the discretion of the interrupted Thread to continue or abort
            es.shutdownNow();

            // Trying to schedule anything after shutting down causes RejectedExecutionException
            es.execute(() -> System.out.println("This does not get printed & will throw RejectedExecutionException"));

            // isTerminated() returns true if all tasks have completed following shutdown
            System.out.println("es.isTerminated()=" + es.isTerminated());
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            es.shutdown();
        }
    }

    public static void shutdown() {
        ExecutorService es = Executors.newFixedThreadPool(2);
        try {
            // Order of execution of these 3 tasks in not guaranteed.
            es.execute(countingTask);
            es.execute(countingTask);
            es.execute(countingTask);

            // shutdown() will NOT interrupt the running threads.
            // However, it will stop accepting further executions.
            es.shutdown();

            // Trying to schedule anything after shutdown
            es.execute(() -> System.out.println("This does not get printed!"));
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            es.shutdown();
        }
    }

    public static void main(String[] args) {
        shutdownNow();
        shutdown();
    }
}
