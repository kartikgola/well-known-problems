/*
 * Author: Kartik Gola
 * Date: 4/16/21, 11:13 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package fundamentals.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MySingleThreadExecutor {

    public static void main(String[] args) {
        ExecutorService es = null;
        try {
            es = Executors.newSingleThreadExecutor();
            System.out.println(Thread.currentThread().getName() + " Begin");

            // Order of these ES tasks are guaranteed!
            es.submit(() -> System.out.println("Doing task...1"));
            es.submit(() -> System.out.println("Doing task...2"));
            es.submit(() -> {
                for (int i = 0; i < 10; ++i)
                    System.out.println("Doing task...3." + i);
            });
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
