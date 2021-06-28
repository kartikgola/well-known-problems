/*
 * Author: Kartik Gola
 * Date: 2/16/21, 8:25 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 */

package leetcode;

import java.util.Arrays;

public class TheKWeakestRowsInAMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {
        final int n = mat.length;
        int[][] sums = new int[n][2];

        for (int i = 0; i < n; ++i)
            sums[i] = new int[]{i, Arrays.stream(mat[i]).sum()};

        Arrays.sort(sums, (a, b) -> a[1] - b[1] != 0 ? a[1] - b[1] : a[0] - b[0]);

        int[] ans = new int[k];
        for (int i = 0; i < k; ++i)
            ans[i] = sums[i][0];
        return ans;
    }
}
