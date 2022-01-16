/*
 * Author: Kartik Gola
 * Date: 1/16/22, 1:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package jobscheduler.model;

public class Job {

    private int id;

    // Runnable that will be executed as part of the job's task
    private Runnable runnable;

    // startTime at which job should ideally start
    private long startTime;

    public Job(int id, Runnable runnable, long startTime) {
        this.id = id;
        this.runnable = runnable;
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", startTime=" + startTime +
                '}';
    }
}
