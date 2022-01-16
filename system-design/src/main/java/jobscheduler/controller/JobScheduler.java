/*
 * Author: Kartik Gola
 * Date: 1/16/22, 1:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package jobscheduler.controller;

import jobscheduler.model.Job;

import java.util.List;

public interface JobScheduler {

    /**
     * Schedules a given job based on startTime specified inside the job
     * @param job : Job that needs to be scheduled
     * @return true if job was scheduled; otherwise, false
     */
    boolean schedule(Job job);

    /**
     * Shuts down the Job Scheduler and doesn't accept anymore scheduling requests
     * Similar to how ExecutorService's shutdown() works
     */
    void shutdown();

    /**
     * Shuts down the Job Scheduler and doesn't accept anymore scheduling requests
     * Plus, interrupts all the running jobs and returns a list of jobs that were waiting to be scheduled
     * Similar to how ExecutorService's shutdownNow() works
     * @return List of jobs that were waiting to be scheduled
     */
    List<Job> shutdownNow();
}
