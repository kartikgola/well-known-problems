/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package fundamentals.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueueExample {

    private Queue<String> q = new LinkedList<>();
    private final int LIMIT = 2;

    public synchronized void add(String val) throws InterruptedException {
        while (q.size() == LIMIT)
            wait();
        q.add(val);
        // if Q is not empty, notify the threads that may want to add something in Q
        if (!q.isEmpty())
            notifyAll();
    }

    public synchronized String remove() throws InterruptedException {
        while (q.size() == 0)
            wait();
        String val = q.remove();
        // if Q is not full, notify the threads that may want to add something in Q
        if (q.size() < LIMIT)
            notifyAll();
        return val;
    }

    public static void main(String[] args) {
        BlockingQueueExample mbq = new BlockingQueueExample();
        Runnable addTask = () -> {
            try {
                mbq.add(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable removeTask = () -> {
            try {
                mbq.remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            es.execute(addTask);
            es.execute(removeTask);
        }

        es.shutdown();
    }
}
