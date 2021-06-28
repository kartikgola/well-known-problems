/*
 * Author: Kartik Gola
 * Date: 4/16/21, 11:13 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package fundamentals.concurrency.racecondition;

import java.util.concurrent.*;

public class RaceConditionExample {

    private static int count = 0;

    public static void raceConditionExample() throws InterruptedException {
        ExecutorService es = null;
        final int MAX_THREADS = 20;
        try {
            es = Executors.newFixedThreadPool(MAX_THREADS);
            System.out.println(Thread.currentThread().getName() + " Begin");


            for (int i = 0; i < MAX_THREADS; i++) {
                es.submit(() -> {
                    // reading value of 'count'
                    // Updating 'count' value
                    // This might lead to wrong update due to 2 threads reading same value
                    // and then overwriting it with same value
                    System.out.println(++count);
                });
            }


            System.out.println(Thread.currentThread().getName() + " End");
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            // fail-safe
            es.awaitTermination(2, TimeUnit.SECONDS);
            System.out.println("Final count=" + count);
            es.shutdown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        raceConditionExample();
    }
}
