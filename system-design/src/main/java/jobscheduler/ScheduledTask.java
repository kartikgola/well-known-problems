/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package jobscheduler;

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
