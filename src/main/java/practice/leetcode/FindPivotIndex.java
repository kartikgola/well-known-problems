/*
 * Author: Kartik Gola
 * Date: 19/12/2020, 13:04
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/find-pivot-index/
 */

package practice.leetcode;

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
