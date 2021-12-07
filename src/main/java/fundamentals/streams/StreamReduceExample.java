/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package fundamentals.streams;

import java.util.Arrays;

public class StreamReduceExample {

    private static void reduceExample() {
        System.out.println(
            Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g')
                .parallelStream()
                // .reduce() on parallel stream makes sure that order is preserved
                .reduce("",
                        (ch, str1) -> ch + str1,
                        (str2, str3) -> str2 + str3)
        );
    }

    public static void main(String[] args) {
        reduceExample();
    }
}
