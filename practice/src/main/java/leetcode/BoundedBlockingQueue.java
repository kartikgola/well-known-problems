/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
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

// Solution using 3 Semaphores (permits)
class BoundedBlockingQueue3 {

    private final Queue<Integer> queue;
    private final int capacity;
    private final Semaphore full;
    private final Semaphore empty;
    private final Semaphore mutex;

    public BoundedBlockingQueue3(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        this.full = new Semaphore(0);
        this.empty = new Semaphore(capacity);
        this.mutex = new Semaphore(1);
    }

    public void enqueue(int element) throws InterruptedException {
        empty.acquire();
        mutex.acquire();
        queue.add(element);
        mutex.release();
        full.release();
    }

    public int dequeue() throws InterruptedException {
        full.acquire();
        mutex.acquire();
        int poll = queue.poll();
        mutex.release();
        empty.release();
        return poll;
    }

    public int size() throws InterruptedException {
        mutex.acquire();
        int size = queue.size();
        mutex.release();
        return size;
    }
}

// Solution using 2 Semaphores + queue as monitor
class BoundedBlockingQueue4 {

    private final Queue<Integer> queue;
    private final int capacity;
    private final Semaphore full;
    private final Semaphore empty;

    public BoundedBlockingQueue4(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        this.full = new Semaphore(0);
        this.empty = new Semaphore(capacity);
    }

    public void enqueue(int element) throws InterruptedException {
        empty.acquire();
        synchronized (queue) {
            queue.add(element);
        }
        full.release();
    }

    public int dequeue() throws InterruptedException {
        full.acquire();
        int poll = -1;
        synchronized (queue) {
            poll = queue.poll();
        }
        empty.release();
        return poll;
    }

    public int size() throws InterruptedException {
        int size = 0;
        synchronized (queue) {
            size = queue.size();
        }
        return size;
    }
}
