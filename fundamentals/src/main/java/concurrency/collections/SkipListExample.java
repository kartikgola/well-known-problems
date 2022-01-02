/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package concurrency.collections;

import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.concurrent.*;

public class SkipListExample {

    // SkipList Set/Map are sorted + concurrent versions of TreeSet & TreeMap
    private static NavigableSet<Integer> skipListSet = new ConcurrentSkipListSet<>();
    private static SortedMap<Integer, Integer> skipListMap = new ConcurrentSkipListMap<>();

    public static void skipListExample() {
        ExecutorService es = Executors.newFixedThreadPool(2);
        try {
            es.submit(() -> {
                skipListSet.add(20);
            });
            es.submit(() -> {
                skipListSet.add(10);
            });
            es.submit(() -> {
                skipListSet.add(30);
            });
            es.awaitTermination(2, TimeUnit.SECONDS);
            System.out.println(skipListSet);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } finally {
            es.shutdown();
        }
    }

    public static void main(String[] args) {
        skipListExample();
    }
}
