/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class Sqrtx {

    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        long l = 1, r = x;
        while (l < r) {
            long m = l+(r-l)/2;
            if (m * m > x)
                r = m;
            else
                l = m+1;
        }
        return (int)l-1;
    }
}
