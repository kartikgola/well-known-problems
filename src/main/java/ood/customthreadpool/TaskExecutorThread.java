/*
 * Author: Kartik Gola
 * Date: 11/24/21, 9:26 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package ood.customthreadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskExecutorThread implements Runnable {

    private Thread currentThread = null;
    private AtomicInteger pendingTasks = null;
    private BlockingQueue<Runnable> tasksQueue = null;
    private boolean isStopped = false;

    public TaskExecutorThread(BlockingQueue<Runnable> tasksQueue, AtomicInteger pendingTasks) {
        this.tasksQueue = tasksQueue;
        this.pendingTasks = pendingTasks;
    }

    @Override
    public void run() {
        this.currentThread = Thread.currentThread();
        while (!isStopped()) {
            try {
                tasksQueue.take().run();
                pendingTasks.getAndDecrement();
            } catch (InterruptedException e) {
                // e.printStackTrace();
            }
        }
    }

    public synchronized void stop() {
        isStopped = true;
        currentThread.interrupt();
    }

    public synchronized boolean isStopped() {
        return isStopped;
    }
}