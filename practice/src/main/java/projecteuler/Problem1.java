/*
 * Author: Kartik Gola
 * Date: 28/08/2020, 22:44
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://projecteuler.net/problem=1
 */

package projecteuler;

public class Problem1 {

    public int solve() {
        final int LIMIT = 1000;
        int sum = 0;
        for (int num = 1; num < LIMIT; ++num) {
            if (num % 5 == 0 || num % 3 == 0)
                sum += num;
        }
        return sum;
    }
}
