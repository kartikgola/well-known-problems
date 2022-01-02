/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class FibonacciNumber {

    public int fib(int N) {
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        return fib(N - 1) + fib(N - 2);
    }
}
