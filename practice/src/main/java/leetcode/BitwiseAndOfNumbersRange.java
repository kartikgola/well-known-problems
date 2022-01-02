/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class BitwiseAndOfNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // find the common 1-bits prefix
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        while (m < n) {
            // turn off rightmost 1-bit
            n = n & (n - 1);
        }
        return m & n;
    }
}
