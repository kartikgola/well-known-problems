/*
 * Author: Kartik Gola
 * Date: 02/08/20, 11:22 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/max-consecutive-ones-ii/
 */

package leetcode;

public class MaxConsecutiveOnes2 {

    public int findMaxConsecutiveOnes(int[] nums) {
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

            // Since we can only swap 1 zero, we need to make sure that our window is valid
            while ( zeros > 1 ) {
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
