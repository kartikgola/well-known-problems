/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package concurrency.collections;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CopyOnWriteArrayListExample {

    public static void copyOnWriteArrayListExample() throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        try {
            // CopyOnWriteArrayList will copy the entire list internally
            // The reference to old list, however, will not change
            // This is LIKE an Immutable List with the difference that the old reference is kept.
            List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(1,2,3));

            for(Integer item: list) {
                System.out.print(item + " ");
                // Adding elements to list will not affect the current iterator of 'list'
                list.add(4);
            }

            // However, the 'list' currently contains [1,2,3,4,4,4]
            System.out.println("\n" + list);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            es.shutdown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        copyOnWriteArrayListExample();
    }
}
