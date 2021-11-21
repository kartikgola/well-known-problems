/*
 * Author: Kartik Gola
 * Date: 11/21/21, 2:41 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package fundamentals.concurrency;

public class ThreadCreation {

    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("Running thread t1");
            }
        };

        Thread t2 = new Thread(() -> {
            System.out.println("Running thread t2");
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running thread t3");
            }
        });
    }

}
