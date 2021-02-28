/*
 * Author: Kartik Gola
 * Date: 27/02/2021, 18:40
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package multithreading;

public class ImplementRunnable {

    class RunnableImpl implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread is running...");
        }
    }

    Runnable runnableAnonymousImpl = new Runnable() {
        @Override
        public void run() {
            System.out.println("Thread is running...");
        }
    };

    // This is possible because the Runnable interface only has a single unimplemented method,
    // and is therefore practically (although possibly unintentionally) a functional Java interface
    Runnable runnableLambdaImpl = () -> System.out.println("Thread is running...");

    public void startThreadWithRunnable() {
        Thread thread = new Thread(runnableLambdaImpl, "runnableLambdaImpl");
        thread.start();
    }
}
