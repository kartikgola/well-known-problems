/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package fundamentals.concurrency.streams;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ParallelStreamExample {

    private static void parallelStreamExample() {
        long start = System.currentTimeMillis();
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            .parallelStream()
            .map(val -> {
                for (int task = 1; task <= 1e7; ++task);
                return val;
            })
            .collect(Collectors.toList())
        );
        System.out.println("Time taken for .parallelStream()=" + (System.currentTimeMillis() - start) + "ms");
    }

    private static void streamExample() {
        long start = System.currentTimeMillis();
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .parallelStream()
                .map(val -> {
                    for (int task = 1; task <= 1e8; ++task);
                    return val;
                })
                .collect(Collectors.toList())
        );
        System.out.println("Time taken for .stream()=" + (System.currentTimeMillis() - start) + "ms");
    }

    public static void main(String[] args) {
        streamExample();
        parallelStreamExample();
    }
}
