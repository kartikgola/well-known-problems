/*
 * Author: Kartik Gola
 * Date: 14/01/2021, 01:08
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/minimum-size-subarray-sum
 */

package practice.leetcode;

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
