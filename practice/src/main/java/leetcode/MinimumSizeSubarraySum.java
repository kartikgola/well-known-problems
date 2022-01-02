/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        final int n = nums.length;
        int begin = 0,
                end = 0,
                sum = 0,
                minLen = Integer.MAX_VALUE;

        while (end < n) {
            sum += nums[end++];
            while (sum >= s) {
                minLen = Math.min(minLen, end - begin);
                sum -= nums[begin++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
