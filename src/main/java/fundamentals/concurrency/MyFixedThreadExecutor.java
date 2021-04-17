/*
 * Author: Kartik Gola
 * Date: 4/16/21, 11:13 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package fundamentals.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyFixedThreadExecutor {

    public static void main(String[] args) {
        ExecutorService es = null;
        try {
            es = Executors.newFixedThreadPool(4);
            System.out.println(Thread.currentThread().getName() + " Begin");

            // Order of these ES tasks are guaranteed!
            es.execute(() -> System.out.println("Doing task...1"));
            es.execute(() -> System.out.println("Doing task...2"));
            es.execute(() -> {
                for (int i = 0; i < 1e9; ++i);
            });
            System.out.println(es.shutdownNow());
            es.submit(() -> System.out.println("Doing task...4"));
            es.submit(() -> System.out.println("Doing task...5"));

            System.out.println(Thread.currentThread().getName() + " End");
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            es.shutdown();
        }
    }
}
