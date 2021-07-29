/*
 * Author: Kartik Gola
 * Date: 7/28/21, 12:16 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int ans = 1000_000;
        final int n = nums.length;
        Arrays.sort(nums);

        for ( int i = 0; i < n - 2; ++i ) {
            int j = i + 1;
            int k = n - 1;
            int sum = target - nums[i];
            if ( i == 0 || nums[i] != nums[i - 1] ) {
                while ( j < k ) {
                    if ( nums[j] + nums[k] == sum ) {
                        return nums[j] + nums[k] + nums[i];
                    } else {
                        if (Math.abs(nums[j] + nums[k] + nums[i] - target) < Math.abs(ans - target))
                            ans = nums[j] + nums[k] + nums[i];
                        if ( nums[j] + nums[k] > sum ) --k;
                        else ++j;
                    }
                }
            }
        }

        return ans;
    }
}
