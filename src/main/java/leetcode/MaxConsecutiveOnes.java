/*
 * Author: Kartik Gola
 * Date: 02/08/20, 11:31 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/max-consecutive-ones/
 */

package leetcode;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        final int n = nums.length;
        if ( n < 1 )
            return 0;
        int left = 0, right = 0;
        int zeros = 0;
        int maxLen = Integer.MIN_VALUE;

        while ( right < n ) {
            if ( nums[right] == 0 )
                ++zeros;
            ++right;

            if ( zeros > 0 ) {
                zeros = 0;
                left = right;
            }

            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
