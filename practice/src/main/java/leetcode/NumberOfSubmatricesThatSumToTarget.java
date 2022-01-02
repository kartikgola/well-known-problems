/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubmatricesThatSumToTarget {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0) {
                    matrix[i][j] += j-1 >= 0 ? matrix[i][j-1] : 0;
                } else if (j == 0) {
                    matrix[i][j] += i-1 >= 0 ? matrix[i-1][j] : 0;
                } else {
                    matrix[i][j] += matrix[i][j-1] + matrix[i-1][j] - matrix[i-1][j-1];
                }
            }
        }

        int ans = 0;
        // end row
        for (int r2 = 0; r2 < m; ++r2) {
            // begin row
            for (int r1 = 0; r1 <= r2; ++r1) {
                // Now, this problem is same as "Subarray sum equals K", where subarray is of size (r2-r1+1, c)
                Map<Integer, Integer> map = new HashMap<>(){{ put(0, 1); }};
                for (int c = 0; c < n; ++c) {
                    int sum = matrix[r2][c] - (r1-1 >= 0 ? matrix[r1-1][c] : 0);
                    int diff = sum - target;
                    ans += map.getOrDefault(diff, 0);
                    map.put(sum, map.getOrDefault(sum, 0)+1);
                }
            }
        }

        return ans;
    }
}
