/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package jobscheduler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskExecutorThread implements Runnable {

    private Thread currentThread = null;
    private BlockingQueue<ScheduledTask> tasksQueue = null;
    private boolean isStopped = false;
    private final AtomicInteger pendingTasks;

    public TaskExecutorThread(BlockingQueue<ScheduledTask> tasksQueue, AtomicInteger pendingTasks) {
        this.tasksQueue = tasksQueue;
        this.pendingTasks = pendingTasks;
    }

    @Override
    public void run() {
        this.currentThread = Thread.currentThread();
        while (!isStopped()) {
            try {
                // Check if it is time to run peek task of PQ
                ScheduledTask scheduledTask = tasksQueue.take();
                if (System.currentTimeMillis() >= scheduledTask.getStartTime()) {
                    scheduledTask.getTask().run();
                    pendingTasks.decrementAndGet();
                } else {
                    tasksQueue.offer(scheduledTask);
                }
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