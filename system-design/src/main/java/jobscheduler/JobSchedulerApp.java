/*
 * Author: Kartik Gola
 * Date: 1/16/22, 1:29 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package jobscheduler;

import jobscheduler.controller.JobScheduler;
import jobscheduler.controller.SimpleJobScheduler;
import jobscheduler.model.Job;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JobSchedulerApp {

    public static void exampleRun1() throws InterruptedException {
        JobScheduler jobScheduler = new SimpleJobScheduler(2);
        jobScheduler.schedule(new Job(5, () -> System.out.println("Job 5"), System.currentTimeMillis() + 8000));
        jobScheduler.schedule(new Job(2, () -> System.out.println("Job 2"), System.currentTimeMillis() + 4000));
        jobScheduler.schedule(new Job(3, () -> System.out.println("Job 3"), System.currentTimeMillis() + 4000));
        jobScheduler.schedule(new Job(4, () -> System.out.println("Job 4"), System.currentTimeMillis() + 4000));
        jobScheduler.schedule(new Job(6, () -> System.out.println("Job 6"), System.currentTimeMillis() + 10000));
        jobScheduler.schedule(new Job(1, () -> System.out.println("Job 1"), System.currentTimeMillis() + 1000));
        jobScheduler.shutdown();

        Thread.sleep(5000);
        System.out.println(jobScheduler.shutdownNow());
    }

    public static void exampleRun2() throws InterruptedException {
        JobScheduler jobScheduler = new SimpleJobScheduler(2);
        ExecutorService es = Executors.newCachedThreadPool();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int id = i;
            es.execute(() -> jobScheduler.schedule(
                    new Job(id, () -> System.out.println("Job " + id + " completed!"),
                            System.currentTimeMillis() + rand.nextInt(5000)
                    )
            ));
        }

        Thread.sleep(5000);
        System.out.println(jobScheduler.shutdownNow());
    }

    public static void main(String[] args) throws InterruptedException {
        exampleRun1();
        exampleRun2();
    }
}
