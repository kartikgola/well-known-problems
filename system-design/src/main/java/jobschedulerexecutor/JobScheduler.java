/*
 * Author: Kartik Gola
 * Date: 1/16/22, 12:01 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package jobschedulerexecutor;

import java.util.Comparator;
import java.util.concurrent.*;

public class JobScheduler {

    private final BlockingQueue<Job> jobQueue = new PriorityBlockingQueue<>(10, Comparator.comparingLong(Job::getStartTime));
    private final ExecutorService workerService;
    private final ExecutorService checkerService;
    private Future<Void> checkerFuture = null;

    public JobScheduler(int maxWorkerThreads) {
        workerService = Executors.newFixedThreadPool(maxWorkerThreads);
        checkerService = Executors.newFixedThreadPool(1);
        init();
    }

    private void init() {
        checkerFuture = checkerService.submit(() -> {
            while (true) {
                try {
                    Job job = jobQueue.take();
                    System.out.println(job);
                    long currentTime = System.currentTimeMillis();
                    if (job.getStartTime() <= currentTime) {
                        workerService.execute(job.getRunnable());
                    } else {
                        jobQueue.put(job);
                        long diff = job.getStartTime() - currentTime;
                        System.out.println("Sleeping for " + diff + "ms");
                        Thread.sleep(diff);
                    }
                } catch (InterruptedException ie) {
                    System.out.println("Woken by schedule(). Resuming...");
                }
            }
        });
    }

    public void schedule(Job job) {
        try {
            jobQueue.put(job);
            if (checkerFuture != null) {
                checkerFuture.cancel(true);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
