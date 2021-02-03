/*
 * Author: Kartik Gola
 * Date: 03/02/2021, 08:53
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package leetcode;

public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int mask = 1;
        int times = 32;
        int count = 0;
        while (times-- > 0) {
            count += (mask & n) != 0 ? 1 : 0;
            mask <<= 1;
        }
        return count;
    }
}
