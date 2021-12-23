/*
 * Author: Kartik Gola
 * Date: 12/23/21, 1:07 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Solution using monitor and wait/notify
public class BoundedBlockingQueue {

    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void enqueue(int element) throws InterruptedException {
        while (queue.size() == capacity)
            wait();
        queue.add(element);
        notifyAll();
    }

    public synchronized int dequeue() throws InterruptedException {
        while (queue.size() == 0)
            wait();
        int ans = queue.poll();
        notifyAll();
        return ans;
    }

    public synchronized int size() {
        return queue.size();
    }
}

// Solution using ReentrantLock and 2 conditions
class BoundedBlockingQueue2 {

    private final Queue<Integer> queue;
    private final int capacity;
    private final Lock lock = new ReentrantLock();
    private final Condition fullCondition = lock.newCondition();
    private final Condition emptyCondition = lock.newCondition();

    public BoundedBlockingQueue2(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity)
                fullCondition.await();
            queue.add(element);
            emptyCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty())
                emptyCondition.await();
            int poll = queue.poll();
            fullCondition.signalAll();
            return poll;
        } finally {
            lock.unlock();
        }
    }

    public int size() throws InterruptedException {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }
}
