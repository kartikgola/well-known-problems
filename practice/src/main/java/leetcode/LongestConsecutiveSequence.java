/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, j = 0, rep = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i-1]+1) {
                ans = Math.max(ans, i-j-rep);
                j = i;
                rep = 0;
            } else if (nums[i] == nums[i-1]) {
                rep++;
            }
        }
        ans = Math.max(ans, nums.length-j-rep);
        return ans;
    }
}
