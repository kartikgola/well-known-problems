/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package fundamentals.concurrency.collections;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObtainingSyncCollections {

    public static void obtainingSyncCollectionsExample() {
        // if you are given an existing collection that is not a concurrent class and
        // need to access it among multiple threads, you can wrap it using Collections.synchronizedXXX() methods
        // These synchronized collections do not synchronize on iterators
        // So, any such scenario should be handled with 'synchronized' code block monitoring on the collection object.
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());

        ExecutorService es = Executors.newFixedThreadPool(2);
        try {
            es.execute(() -> {
                // Keeps modifying the list
                for (int elem = 1; elem <= 1000_000; ++elem)
                    list.add(elem);
            });
            es.execute(() -> {
                // This results in ConcurrentModificationException
                // For such a scenario, it is better to use CopyOnWriteArrayList
                // Or use a synchronized code block (See Example 2)
                for (Integer val: list)
                    System.out.print(val + ":");
            });
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            es.shutdown();
        }
    }

    public static void obtainingSyncCollectionsExample2() {
        // if you are given an existing collection that is not a concurrent class and
        // need to access it among multiple threads, you can wrap it using Collections.synchronizedXXX() methods
        // These synchronized collections do not synchronize on iterators
        // So, any such scenario should be handled with 'synchronized' code block monitoring on the collection object.
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());

        ExecutorService es = Executors.newFixedThreadPool(2);
        try {
            es.execute(() -> {
                // Keeps modifying the list
                synchronized (list) {
                    for (int elem = 1; elem <= 1000; ++elem)
                        list.add(elem);
                }
            });
            es.execute(() -> {
                synchronized (list) {
                    for (Integer val: list)
                        System.out.println(":start:" + val + ":end:");
                }
            });
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            es.shutdown();
        }
    }

    public static void obtainingSyncCollectionsExample3() {
        try {
            Map<String, Object> foodData = new HashMap<String, Object>();
            foodData.put("penguin", 1);
            foodData.put("flamingo", 2);
            Map<String,Object> synchronizedFoodData = Collections.synchronizedMap(foodData);

            for(String key: synchronizedFoodData.keySet()) {
                // Throws ConcurrentModificationException
                synchronizedFoodData.remove(key);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        obtainingSyncCollectionsExample3();
    }
}