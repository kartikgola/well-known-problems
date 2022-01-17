/*
 * Author: Kartik Gola
 * Date: 1/16/22, 1:29 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package jobscheduler.controller;

import jobscheduler.controller.JobScheduler;
import jobscheduler.model.Job;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class SimpleJobScheduler implements JobScheduler {

    private final BlockingQueue<Job> jobQueue = new PriorityBlockingQueue<>(10, Comparator.comparingLong(Job::getStartTime));
    private final List<Thread> workerThreads;
    private final Thread checkerThread;

    private volatile boolean canShutdown = false;
    private volatile boolean shutdownNow = false;

    private volatile List<Job> waitingJobs = null;
    private final Lock drainLock = new ReentrantLock();
    private final Condition drainComplete = drainLock.newCondition();

    public SimpleJobScheduler(int maxWorkerThreads) {
        this.workerThreads = new ArrayList<>(Collections.nCopies(maxWorkerThreads, null));
        checkerThread = new Thread(() -> {
            while (true) {
                try {
                    // In case of shutdownNow
                    // 1. clear the BlockingQueue
                    // 2. interrupt all the running threads
                    if (shutdownNow) {
                        drainLock.lock();
                            waitingJobs = new ArrayList<>();
                            jobQueue.drainTo(waitingJobs);
                            workerThreads.stream()
                                    .filter(Objects::nonNull)
                                    .forEach(Thread::interrupt);
                        drainComplete.signalAll();
                        drainLock.unlock();
                        return;
                    }

                    // 1. Try to take one job from jobQueue
                    Job job = jobQueue.take();
                    long currentTime = System.currentTimeMillis();

                    // 2. Check if it is the right time to schedule this job
                    if (job.getStartTime() <= currentTime) {

                        // 2.1 Try to find a free/dead thread that can execute the job's runnable
                        int freeThreadIndex = IntStream.range(0, workerThreads.size())
                                .filter(i -> workerThreads.get(i) == null || !workerThreads.get(i).isAlive())
                                .findFirst()
                                .orElse(-1);

                        // 2.2 If not found, put job back into jobQueue; otherwise, start it with a thread
                        if (freeThreadIndex == -1)
                            jobQueue.put(job);
                        else {
                            workerThreads.set(freeThreadIndex, new Thread(job.getRunnable()));
                            workerThreads.get(freeThreadIndex).start();
                        }
                    } else {
                        // 3. Put the job back into jobQueue and sleep until the nearest job needs to be scheduled
                        jobQueue.put(job);
                        Thread.sleep(job.getStartTime() - currentTime);
                    }
                } catch (InterruptedException ie) {
                    // System.out.println("Woken up by schedule(). Resuming...");
                }
            }
        });
        checkerThread.start();
    }

    public synchronized boolean schedule(Job job) {
        try {
            if (canShutdown)
                return false;
            jobQueue.put(job);
            checkerThread.interrupt();
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public synchronized void shutdown() {
        canShutdown = true;
        checkerThread.interrupt();
    }

    public synchronized List<Job> shutdownNow() {
        shutdownNow = true;
        shutdown();
        try {
            drainLock.lock();
            while (waitingJobs == null)
                drainComplete.await();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            drainLock.unlock();
        }


        return waitingJobs;
    }
}
