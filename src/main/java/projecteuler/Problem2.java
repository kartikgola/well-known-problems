/*
 * Author: Kartik Gola
 * Date: 28/02/2021, 19:09
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: 
 */

package projecteuler;

public class Problem2 {

    public int solve() {
        final int LIMIT = 4000_000;
        int a = 1, b = 2;
        int sum = 0;
        while (b <= LIMIT) {
            if (b % 2 == 0)
                sum += b;
            int temp = a;
            a = b;
            b += temp;
        }
        return sum;
    }
}
