/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        final int n = nums.length;
        if (n == 0)
            return -1;

        int[] postSum = new int[n];
        for (int i = n - 1; i > -1; --i) {
            postSum[i] = nums[i] + (i < n - 1 ? postSum[i + 1] : 0);
        }

        int[] preSum = new int[n];
        for (int i = 0; i < n; ++i) {
            preSum[i] = nums[i] + (i > 0 ? preSum[i - 1] : 0);
        }

        for (int i = 0; i < n; ++i) {
            if ((i - 1 >= 0 ? preSum[i - 1] : 0) == (i + 1 <= n - 1 ? postSum[i + 1] : 0)) {
                return i;
            }
        }

        return -1;
    }
}
