/*
 * Author: Kartik Gola
 * Date: 1/15/22, 11:59 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package jobschedulerexecutor;

public class JobSchedulerApp {

    public static void main(String[] args) throws InterruptedException {
        JobScheduler jobScheduler = new JobScheduler(2);
        jobScheduler.schedule(new Job(3, () -> System.out.println("Job 3"), System.currentTimeMillis() + 8000));
        jobScheduler.schedule(new Job(1, () -> System.out.println("Job 1"), System.currentTimeMillis() + 4000));
        jobScheduler.schedule(new Job(2, () -> System.out.println("Job 2"), System.currentTimeMillis() + 10000));

        Thread.sleep(500);

        jobScheduler.schedule(new Job(4, () -> System.out.println("Job 4"), System.currentTimeMillis() + 1000));
    }
}
