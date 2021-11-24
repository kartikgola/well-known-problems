/*
 * Author: Kartik Gola
 * Date: 11/23/21, 10:04 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package ood.customthreadpool;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomThreadPool {

    private BlockingQueue<Runnable> tasksQueue = null;
    private final List<TaskExecutorThread> taskExecutorThreads = new ArrayList<>();
    private final AtomicInteger pendingTasks = new AtomicInteger(0);
    private boolean isStopped = false;

    public CustomThreadPool(int maxThreads, int maxTasks) {
        this.tasksQueue = new ArrayBlockingQueue<>(maxTasks);
        for (int i = 0; i < maxThreads; ++i) {
            taskExecutorThreads.add(new TaskExecutorThread(tasksQueue, pendingTasks));
        }
        for (TaskExecutorThread taskExecutorThread : taskExecutorThreads) {
            new Thread(taskExecutorThread).start();
        }
    }

    public synchronized void execute(Runnable task) throws Exception {
        if (isStopped)
            throw new IllegalStateException("ScheduledThreadPool is stopped!");
        pendingTasks.getAndIncrement();
        tasksQueue.offer(task);
    }

    public synchronized void stop() {
        this.isStopped = true;
        for (TaskExecutorThread taskExecutorThread : taskExecutorThreads) {
            taskExecutorThread.stop();
        }
    }

    public synchronized void waitUntilAllTasksFinished() {
        while (pendingTasks.get() > 0) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
