/*
 * Author: Kartik Gola
 * Date: 02/08/20, 11:25 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/max-consecutive-ones-iii/
 */

package practice.leetcode;

public class MaxConsecutiveOnes3 {

    public int longestOnes(int[] nums, int k) {
        final int n = nums.length;
        if ( n < 1 )
            return 0;
        // Count of ones is not really needed
        int ones = 0, zeros = 0;
        int left = 0, right = 0;
        int maxLen = Integer.MIN_VALUE;

        while ( right < n ) {
            if ( nums[right] == 1 )
                ++ones;
            else
                ++zeros;
            ++right;

            // Since we can only swap `k` zeroes, we need to make sure that our window is valid
            while ( zeros > k ) {
                if ( nums[left] == 1 )
                    --ones;
                else
                    --zeros;
                ++left;
            }

            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
