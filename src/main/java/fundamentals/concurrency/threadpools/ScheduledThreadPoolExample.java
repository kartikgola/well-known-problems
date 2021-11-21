/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package fundamentals.concurrency.threadpools;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {

    private static int time = 0;
    private static Runnable incAndPrintTime = () -> System.out.println(Thread.currentThread().getName() + " time is " + time++);

    public static void scheduleAtFixedRate() throws InterruptedException {
        ScheduledExecutorService es = Executors.newSingleThreadScheduledExecutor();
        try {
            // Trying to run every 1 sec after initial 2 sec delay
            es.scheduleAtFixedRate(incAndPrintTime, 2, 1, TimeUnit.SECONDS);
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            // fail-safe
            es.awaitTermination(5, TimeUnit.SECONDS);
            es.shutdown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        scheduleAtFixedRate();
    }
}
