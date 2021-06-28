/*
 * Author: Kartik Gola
 * Date: 4/16/21, 11:13 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package fundamentals.concurrency;

public class CheckResults {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < 5000000; ++i)
                CheckResults.counter++;
        }).start();

        while (CheckResults.counter < 25000) {
            Thread.sleep(1);
            System.out.println("Not ready yet!" + CheckResults.counter);
        }

        System.out.println("Ready!");
    }
}
