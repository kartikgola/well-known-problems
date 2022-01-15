/*
 * Author: Kartik Gola
 * Date: 1/15/22, 10:34 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package concurrency.liveness;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {

    private static void example1() {
        ExecutorService es = Executors.newFixedThreadPool(2);
        try {
            Object obj1 = new Object();
            Object obj2 = new Object();

            es.execute(() -> {
                synchronized (obj1) {
                    // uncomment line below to simulate a possible deadlock scenario
                    // try { Thread.sleep(10); } catch (Exception e) {}
                    synchronized (obj2) {
                        System.out.println(Thread.currentThread());
                    }
                }
            });

            es.execute(() -> {
                synchronized (obj2) {
                    synchronized (obj1) {
                        System.out.println(Thread.currentThread());
                    }
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

    private static void example2() {
        ExecutorService es = Executors.newFixedThreadPool(2);
        try {
            Lock lock1 = new ReentrantLock();
            Lock lock2 = new ReentrantLock();

            es.execute(() -> {
                lock1.lock();
                lock2.lock();
                System.out.println(Thread.currentThread());
                lock2.unlock();
                lock1.unlock();
            });

            es.execute(() -> {
                lock2.lock();
                lock1.lock();
                System.out.println(Thread.currentThread());
                lock1.unlock();
                lock2.unlock();
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
