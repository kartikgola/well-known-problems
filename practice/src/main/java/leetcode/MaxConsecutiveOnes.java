/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
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
