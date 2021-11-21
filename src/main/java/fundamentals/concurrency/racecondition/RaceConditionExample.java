/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package fundamentals.concurrency.racecondition;

import java.util.concurrent.*;

public class RaceConditionExample {

    private static int count = 0;

    public static void raceConditionExample() throws InterruptedException {
        final int MAX_THREADS = 20;
        ExecutorService es = Executors.newFixedThreadPool(MAX_THREADS);
        try {
            for (int i = 0; i < MAX_THREADS; i++) {
                es.submit(() -> {
                    // reading value of 'count'
                    // Updating 'count' value
                    // This might lead to wrong update due to 2 threads reading same value
                    // and then overwriting it with same value
                    System.out.println(count += 1);
                });
            }
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
