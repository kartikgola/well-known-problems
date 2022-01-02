/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
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
