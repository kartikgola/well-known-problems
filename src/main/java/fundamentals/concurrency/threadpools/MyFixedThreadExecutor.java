/*
 * Author: Kartik Gola
 * Date: 4/16/21, 11:13 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package fundamentals.concurrency.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyFixedThreadExecutor {

    public static void shutdownNowExample() {
        ExecutorService es = null;
        try {
            es = Executors.newFixedThreadPool(2);
            System.out.println(Thread.currentThread().getName() + " Begin");

            // Order of these ES tasks are NOT guaranteed in case of a threadpool of size > 1
            es.execute(() -> {
                for (int i = 0; i < 1e1; ++i) {
                    System.out.println("Doing task...1." + i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException interruptedException) {
                        System.out.println("Thread 1 interrupted");
                        // do nothing & continue normally
                    }
                }
            });
            es.execute(() -> {
                for (int i = 0; i < 1e1; ++i) {
                    System.out.println("Doing task...2." + i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException interruptedException) {
                        System.out.println("Thread 2 interrupted");
                        return;
                    }
                }
            });
            es.execute(() -> {
                for (int i = 0; i < 1e1; ++i) {
                    System.out.println("Doing task...3." + i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException interruptedException) {
                        System.out.println("Thread 3 interrupted");
                        return;
                    }
                }
            });

            // shutdownNow() will try to interrupt the thread via Thread.interrupt
            // However, it is up to the discretion of the interrupted Thread to continue or abort
            System.out.println(es.shutdownNow());
            System.out.println("es.isTerminated()=" + es.isTerminated());

            System.out.println(Thread.currentThread().getName() + " End");
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            es.shutdown();
        }
    }

    public static void shutdownExample() {
        ExecutorService es = null;
        try {
            es = Executors.newFixedThreadPool(2);
            System.out.println(Thread.currentThread().getName() + " Begin");

            // Order of execution of ES tasks are NOT guaranteed in case of a thread pool of size > 1
            es.execute(() -> {
                for (int i = 0; i < 1e1; ++i) {
                    System.out.println("Doing task...1." + i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException interruptedException) {
                        System.out.println("Thread 1 interrupted");
                    }
                }
            });
            es.execute(() -> {
                for (int i = 0; i < 1e1; ++i) {
                    System.out.println("Doing task...2." + i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException interruptedException) {
                        System.out.println("Thread 2 interrupted");
                    }
                }
            });
            es.execute(() -> {
                for (int i = 0; i < 1e1; ++i) {
                    System.out.println("Doing task...3." + i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException interruptedException) {
                        System.out.println("Thread 3 interrupted");
                    }
                }
            });

            // shutdown() will stop accepting further task requests and will wait
            // for currently executing threads to finish
            System.out.println("Shutting down es...");
            es.shutdown();
            es.execute(() -> System.out.println("This does not get printed!"));

            System.out.println(Thread.currentThread().getName() + " End");
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            // fail-safe
            es.shutdown();
        }
    }

    public static void main(String[] args) {
        shutdownExample();
    }
}
