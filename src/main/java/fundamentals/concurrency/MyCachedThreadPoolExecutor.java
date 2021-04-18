/*
 * Author: Kartik Gola
 * Date: 4/16/21, 11:13 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package fundamentals.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyCachedThreadPoolExecutor {

    public static void cachedThreadPoolExample() {
        ExecutorService es = null;
        try {
            es = Executors.newCachedThreadPool();
            System.out.println(Thread.currentThread().getName() + " Begin");

            // In theory, this can create 100 threads!
            for(int thread = 1; thread <= 100; ++thread) {
                es.submit(() -> {
                    // do some heavy work!
                    for (int i = 0; i < 1e9; i++);
                });
            }

            System.out.println(Thread.currentThread().getName() + " End");
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            // fail-safe
            es.shutdown();
        }
    }

    public static void main(String[] args) {
//        cachedThreadPoolExample();
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
