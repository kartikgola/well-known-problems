/*
 * Author: Kartik Gola
 * Date: 28/02/2021, 19:09
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: 
 */

package projecteuler;

public class Problem5 {

    public int solve() {
        outer:
        for (int num = 2520; num < 1000_000_000; ++num) {
            for (int div = 1; div <= 20; ++div) {
                if (num % div != 0)
                    continue outer;
            }
            return num;
        }
        return -1;
    }
}
