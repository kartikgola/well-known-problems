/*
 * Author: Kartik Gola
 * Date: 1/16/22, 1:08 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package jobscheduler;

public class JobSchedulerApp {

    public static void main(String[] args) throws InterruptedException {
        JobScheduler jobScheduler = new JobScheduler(2);
        jobScheduler.schedule(new Job(3, () -> System.out.println("Job 3"), System.currentTimeMillis() + 8000));
        jobScheduler.schedule(new Job(1, () -> System.out.println("Job 1"), System.currentTimeMillis() + 4000));
        jobScheduler.schedule(new Job(5, () -> System.out.println("Job 5"), System.currentTimeMillis() + 4000));
        jobScheduler.schedule(new Job(6, () -> System.out.println("Job 6"), System.currentTimeMillis() + 4000));
        jobScheduler.schedule(new Job(2, () -> System.out.println("Job 2"), System.currentTimeMillis() + 10000));

        Thread.sleep(500);

        jobScheduler.schedule(new Job(4, () -> System.out.println("Job 4"), System.currentTimeMillis() + 1000));
    }
}
