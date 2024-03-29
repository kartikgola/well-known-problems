/*
 * Author: Kartik Gola
 * Date: 1/15/22, 10:34 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package concurrency.liveness;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// In Livelock, threads are not stuck per-se but their action or their execution schedule becomes such that
// no overall progress is being made in the system.
// The operations in the 2 threads counter each other
// and so, in theory this process can go on forever!
public class Livelock {

    private static void example1() {
        ExecutorService es = Executors.newFixedThreadPool(2);
        try {
            AtomicInteger x = new AtomicInteger(0);
            es.execute(() -> {
                while (x.get() <= 2) {
                    x.incrementAndGet();
                }
            });

            es.execute(() -> {
                while (x.get() >= -2) {
                    x.decrementAndGet();
                }
            });

            es.shutdown();
            es.awaitTermination(3, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            es.shutdownNow();
        }
    }

    public static void main(String[] args) {
        example1();
    }
}
