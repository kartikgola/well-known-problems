/*
 * Author: Kartik Gola
 * Date: 4/16/21, 11:13 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package fundamentals.concurrency.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MySingleThreadExecutor {

    public static void singleThreadPoolExample1() {
        ExecutorService es = null;
        try {
            es = Executors.newSingleThreadExecutor();
            System.out.println(Thread.currentThread().getName() + " Begin");

            // Order of execution of these ES tasks IS guaranteed if there is only 1 thread
            // That means, 1 thread gets assigned EXACTLY 1 task
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

    public static void singleThreadPoolExample2() throws InterruptedException {
        ExecutorService es = null;
        Future<?> f = null;
        try {
            es = Executors.newSingleThreadExecutor();
            System.out.println(Thread.currentThread().getName() + " Begin");

            // Order of execution of these ES tasks IS guaranteed if there is only 1 thread
            // That means, 1 thread gets assigned EXACTLY 1 task
            f = es.submit(() -> {
                // do some really long task!
                // don't care about interruption
                long i = 0;
                for (; i < 6e9; ++i);
                System.out.println("Done counting! " + i);
            });

            System.out.println(Thread.currentThread().getName() + " End");
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            es.shutdown();
        }

        if (!es.isTerminated()) {
            es.awaitTermination(1, TimeUnit.SECONDS);
            System.out.println("After awaitTermination");

            // f.cancel() will internally call Thread.interrupt()
            // Now, it is up to the discretion of that running thread to acknowledge interruption
            // If that thread is in running state, it needs to check for Thread.currentThread().isInterrupted()
            // Otherwise, if it is waiting/sleeping, it will throw InterruptedException and needs to return after that.
            // However, if that thread does not have proper handling, the program may never terminate! (as shown here)
            f.cancel(true);
            System.out.println("f.isCancelled()=" + f.isCancelled());
            // When control reaches here, ES thread still keeps on going because it does not acknowledge the interruption
        } else {
            System.out.println("ES is already terminated");
        }
    }

    public static void singleThreadPoolExample3() throws InterruptedException {
        ExecutorService es = null;
        Future<?> f = null;
        try {
            es = Executors.newSingleThreadExecutor();
            System.out.println(Thread.currentThread().getName() + " Begin");

            // Order of execution of these ES tasks IS guaranteed if there is only 1 thread
            // That means, 1 thread gets assigned EXACTLY 1 task
            f = es.submit(() -> {
                // do some really long task and account for interruption
                long i = 0;
                for (; i < 6e9 && !Thread.currentThread().isInterrupted(); ++i);
                System.out.println("Done counting! " + i);
            });

            System.out.println(Thread.currentThread().getName() + " End");
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            es.shutdown();
        }

        if (!es.isTerminated()) {
            es.awaitTermination(1, TimeUnit.SECONDS);
            System.out.println("After awaitTermination");

            // f.cancel() will internally call Thread.interrupt()
            // We can also do es.shutdownNow()
            // Now, it is up to the discretion of that running thread to acknowledge interruption
            // If that thread is in running state, it needs to check for Thread.currentThread().isInterrupted()
            // Otherwise, if it is waiting/sleeping, it will throw InterruptedException and needs to return after that.
            f.cancel(true);
            System.out.println("f.isCancelled()=" + f.isCancelled());
            // When control reaches here, ES thread still keeps on going because it does not acknowledge the interruption
        } else {
            System.out.println("ES is already terminated");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        singleThreadPoolExample3();
    }
}
