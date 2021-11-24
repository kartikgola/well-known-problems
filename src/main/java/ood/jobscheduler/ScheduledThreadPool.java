/*
 * Author: Kartik Gola
 * Date: 11/23/21, 10:04 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package ood.jobscheduler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduledThreadPool {

    private BlockingQueue<ScheduledTask> tasksQueue = null;
    private final List<TaskExecutorThread> taskExecutorThreads = new ArrayList<>();
    private boolean isStopped = false;
    private final AtomicInteger pendingTasks = new AtomicInteger(0);

    public ScheduledThreadPool(int maxThreads, int maxTasks) {
        this.tasksQueue = new PriorityBlockingQueue<>(maxTasks, Comparator.comparingLong(ScheduledTask::getStartTime));
        // Create & store instances of TaskExecutorThreads - these threads will be responsible for actually running the given tasks
        for (int i = 0; i < maxThreads; ++i) {
            taskExecutorThreads.add(new TaskExecutorThread(tasksQueue, pendingTasks));
        }
        // Start all threads and keep them running
        for (TaskExecutorThread taskExecutorThread : taskExecutorThreads) {
            new Thread(taskExecutorThread).start();
        }
    }

    // Schedules a job/Runnable at some time equal to startTime in future
    public synchronized void schedule(Runnable task, long startTime) throws Exception {
        if (isStopped)
            throw new IllegalStateException("ScheduledThreadPool is stopped!");
        pendingTasks.incrementAndGet();
        tasksQueue.offer(new ScheduledTask(startTime, task));
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
