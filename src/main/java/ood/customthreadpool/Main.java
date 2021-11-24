/*
 * Author: Kartik Gola
 * Date: 11/24/21, 9:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package ood.customthreadpool;

public class Main {

    public static void main(String[] args) throws Exception {
        final int MAX_THREADS = 5;
        final int MAX_TASKS = 20;
        CustomThreadPool threadPool = new CustomThreadPool(MAX_THREADS, MAX_TASKS);

        for(int i=0; i < MAX_TASKS; i++) {
            int taskNo = i;
            threadPool.execute( () -> {
                String message = Thread.currentThread().getName() + ": Task " + taskNo;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(message);
            });
        }

        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();
    }
}
