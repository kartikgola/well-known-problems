/*
 * Author: Kartik Gola
 * Date: 8/16/21, 11:55 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

import static util.ArrayUtils.Bisect.bisectLeft;

public class LongestIncreasingSubsequence {

    // O(nlog(n)) algorithm
    // Refer Patience Sorting - https://www.cs.princeton.edu/courses/archive/spring13/cos423/lectures/LongestIncreasingSubsequence.pdf
    public int lengthOfLIS(int[] nums) {
        List<Integer> al = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            int l = bisectLeft(al, nums[i]);
            if (l >= al.size()) {
                al.add(nums[i]);
            } else if (nums[i] < al.get(l)) {
                al.set(l, nums[i]);
            }
        }
        return al.size();
    }

    private int lis(int[] nums, int i, Integer[] dp) {
        int ans = 1;
        if (dp[i] != null)
            return dp[i];
        for (int j = i-1; j >= 0; --j) {
            if (nums[j] < nums[i]) {
                ans = Math.max(ans, 1+lis(nums, j, dp));
            }
        }
        return dp[i] = ans;
    }

    // Naive top-down DP
    public int lengthOfLISDP1(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        int ans = 1;
        for (int i = nums.length-1; i >= 0; --i) {
            ans = Math.max(ans, lis(nums, i, dp));
        }
        return ans;
    }

    // Naive bottom-up DP
    public int lengthOfLISDP2(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 1;
        for (int i = 0; i < nums.length; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
