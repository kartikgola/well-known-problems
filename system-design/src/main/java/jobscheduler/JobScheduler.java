/*
 * Author: Kartik Gola
 * Date: 1/16/22, 1:08 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package jobscheduler;

import java.util.Comparator;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class JobScheduler {

    private final BlockingQueue<Job> jobQueue = new PriorityBlockingQueue<>(10, Comparator.comparingLong(Job::getStartTime));
    private final int MAX_WORKER_THREADS;
    private final Thread[] workerThreads;
    private Thread checkerThread = null;
    private boolean canShutdown = false;

    public JobScheduler(int maxWorkerThreads) {
        this.MAX_WORKER_THREADS = maxWorkerThreads;
        this.workerThreads = new Thread[MAX_WORKER_THREADS];
        checkerThread = new Thread(() -> {
            while (!canShutdown) {
                try {
                    Job job = jobQueue.take();
                    long currentTime = System.currentTimeMillis();

                    if (job.getStartTime() <= currentTime) {
                        boolean jobScheduled = false;
                        for (int i = 0; i < workerThreads.length; i++) {
                            if (workerThreads[i] == null || !workerThreads[i].isAlive()) {
                                workerThreads[i] = new Thread(job.getRunnable());
                                workerThreads[i].start();
                                jobScheduled = true;
                                break;
                            }
                        }

                        // if no thread is free, put the job back and wait for 100ms (optional)
                        if (!jobScheduled) {
                            Thread.sleep(100);
                            jobQueue.put(job);
                        }
                    } else {
                        // put the job back into jobQueue and sleep until the nearest job needs to be scheduled
                        jobQueue.put(job);
                        long diff = job.getStartTime() - currentTime;
                         System.out.println("Sleeping for " + diff + "ms");
                        Thread.sleep(diff);
                    }
                } catch (InterruptedException ie) {
                    // System.out.println("Woken up by schedule(). Resuming...");
                }
            }
        });
        checkerThread.start();
    }

    public void schedule(Job job) {
        try {
            jobQueue.put(job);
            checkerThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        canShutdown = true;
        checkerThread.interrupt();
        Stream.of(workerThreads).forEach(Thread::interrupt);
    }
}
