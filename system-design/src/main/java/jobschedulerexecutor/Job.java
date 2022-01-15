/*
 * Author: Kartik Gola
 * Date: 1/15/22, 11:59 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package jobschedulerexecutor;

public class Job {

    private int id;
    private Runnable runnable;
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
