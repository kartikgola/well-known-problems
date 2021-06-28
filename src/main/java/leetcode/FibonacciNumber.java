/*
 * Author: Kartik Gola
 * Date: 27/11/2020, 22:18
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/fibonacci-number/
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
