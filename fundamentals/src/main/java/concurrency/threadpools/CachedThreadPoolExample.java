/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package concurrency.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {

    public static void cachedThreadPoolExample(final int k) {
        ExecutorService es = Executors.newCachedThreadPool();;
        try {
            // In theory, this can create k threads!
            for(int thread = 1; thread <= k; ++thread) {
                es.submit(() -> {
                    // do some heavy work!
                    for (int i = 0; i < 1e9; i++);
                });
            }
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            // fail-safe
            es.shutdown();
        }
    }

    public static void main(String[] args) {
        System.out.println("Available processors=" + Runtime.getRuntime().availableProcessors());
        cachedThreadPoolExample(Runtime.getRuntime().availableProcessors());
    }

}
