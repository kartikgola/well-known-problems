/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package concurrency.racecondition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void atomicExample() throws InterruptedException {
        ExecutorService es = null;
        final int MAX_THREADS = 10;
        try {
            es = Executors.newFixedThreadPool(MAX_THREADS);
            System.out.println(Thread.currentThread().getName() + " Begin");


            for (int i = 0; i < MAX_THREADS; i++) {
                es.execute(() -> {
                    // Incorrect way to increment value
                    atomicInteger.set(atomicInteger.get() + 1);
                });
            }


            System.out.println(Thread.currentThread().getName() + " End");
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            // fail-safe
            es.awaitTermination(2, TimeUnit.SECONDS);
            // This value may still NOT match MAX_THREADS value
            System.out.println("Final count=" + atomicInteger.get());
            es.shutdown();
        }
    }

    public static void atomicExample2() throws InterruptedException {
        ExecutorService es = null;
        final int MAX_THREADS = 100;
        try {
            es = Executors.newFixedThreadPool(MAX_THREADS);
            System.out.println(Thread.currentThread().getName() + " Begin");


            for (int i = 0; i < MAX_THREADS; i++) {
                es.execute(() -> {
                    // Correct way to do ++value
                    // This will make sure that final value is correct
                    // but still may cause a sequence like 2 1 3 4 5 6 7...
                    System.out.print(atomicInteger.incrementAndGet() + " ");
                });
            }


            System.out.println(Thread.currentThread().getName() + " End");
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            // fail-safe
            es.awaitTermination(3, TimeUnit.SECONDS);
            // This value may still NOT match MAX_THREADS value
            System.out.println("Final count=" + atomicInteger.get());
            es.shutdown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        atomicExample2();
    }
}
