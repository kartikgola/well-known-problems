/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        final int n = A.length;
        if (n < 3) return 0;

        int slices = 0;
        // 'j' indicates the starting index of equal differences sub-array
        // 'i' indicates the current index
        for (int i = 2, j = 1; i < n; ++i) {
            if (A[i] - A[i-1] == A[j] - A[j-1]) {
                slices += i - j;
            } else {
                j = i;
            }
        }

        return slices;
    }
}
