/*
 * Author: Kartik Gola
 * Date: 11/24/21, 9:43 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package ood.jobscheduler;

public class ScheduledTask {

    // time in millis at which the task will start
    private final Long startTime;
    private final Runnable task;

    public ScheduledTask(Long startTime, Runnable task) {
        this.startTime = startTime;
        this.task = task;
    }

    public Long getStartTime() {
        return startTime;
    }

    public Runnable getTask() {
        return task;
    }
}
