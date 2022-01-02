/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package jobscheduler;

public class Main {

    public static void main(String[] args) throws Exception {
        final int MAX_THREADS = 5;
        final int MAX_TASKS = 20;
        ScheduledThreadPool threadPool = new ScheduledThreadPool(MAX_THREADS, MAX_THREADS);

        for(int i=0; i < MAX_TASKS; i++) {
            int taskNo = i;
            threadPool.schedule( () -> {
                String message = Thread.currentThread().getName() + ": Task " + taskNo;
                // some heavy work
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(message);
            }, System.currentTimeMillis() + (i+1) * 2000);
        }

        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();
    }
}
