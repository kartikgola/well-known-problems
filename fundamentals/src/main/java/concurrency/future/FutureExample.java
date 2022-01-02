/*
 * Author: Kartik Gola
 * Date: 11/21/21, 3:38 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package concurrency.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {

    public static void futureExample1() {
        ExecutorService es = Executors.newSingleThreadExecutor();
        try {
            Future<String> f = es.submit(() -> {
                long max = (long)5e9;
                for (long i = 0; i < max; i++);
                return "Finished counting till " + max;
            });

            // future.get() method will wait indefinitely until response is received
            System.out.println(f.get());
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            // fail-safe
            es.shutdown();
        }
    }

    public static void futureExample2() {
        ExecutorService es = Executors.newSingleThreadExecutor();
        try {
            Future<?> f = es.submit(() -> {
                for (int i = 0; i < 1e1; ++i) {
                    System.out.println("Doing task...1." + i);
                }
                // returns nothing
            });

            // future.get() method will wait indefinitely until response is received
            // By default, if task returns nothing, future.get() will have value as null
            System.out.println(f.get());
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            // fail-safe
            es.shutdown();
        }
    }

    public static void main(String[] args) {
        futureExample1();
        futureExample2();
    }
}
