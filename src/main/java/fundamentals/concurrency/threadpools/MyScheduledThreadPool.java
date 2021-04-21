/*
 * Author: Kartik Gola
 * Date: 4/16/21, 11:13 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package fundamentals.concurrency.threadpools;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyScheduledThreadPool {

    static int time = 0;

    public static void scheduledThreadsExample() throws InterruptedException {
        ScheduledExecutorService es = null;
        try {
            es = Executors.newSingleThreadScheduledExecutor();
            System.out.println(Thread.currentThread().getName() + " Begin");


            es.scheduleAtFixedRate(() -> {
                System.out.println("Trying to execute every 1 second. Time = " + ++time);
            }, 0, 1, TimeUnit.SECONDS);


            System.out.println(Thread.currentThread().getName() + " End");
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            // fail-safe
            es.awaitTermination(5, TimeUnit.SECONDS);
            es.shutdown();
        }
    }

    private static long prevTime;

    public static void scheduledThreadsExample2() throws InterruptedException {
        ScheduledExecutorService es = null;
        try {
            es = Executors.newSingleThreadScheduledExecutor();
            System.out.println(Thread.currentThread().getName() + " Begin");
            prevTime = System.currentTimeMillis();

            es.scheduleWithFixedDelay(() -> {
                long currTime = System.currentTimeMillis();
                System.out.println("Trying to execute with 1s delay. Time since last exec=" + (currTime - prevTime)/1000.0);
                // do some task
                double task = 1e5;
                while (task-- > 0);
                prevTime = System.currentTimeMillis();
            }, 0, 1, TimeUnit.SECONDS);


            System.out.println(Thread.currentThread().getName() + " End");
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            // fail-safe
            es.awaitTermination(5, TimeUnit.SECONDS);
            es.shutdown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        scheduledThreadsExample2();
    }
}
