/*
 * Author: Kartik Gola
 * Date: 9/15/21, 6:11 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimalAccountBalancing {

    private Integer[] dp;

    private int sum(int mask, Integer[] nums) {
        int x = 1;
        int i = nums.length-1;
        int sum = 0;
        while (x <= mask) {
            if ((x & mask) > 0)
                sum += nums[i];
            i--;
            x <<= 1;
        }
        return sum;
    }

    private List<Integer> subMask(int mask) {
        if (mask == 0)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int x = 1;
        while (x > 0) {
            if ((x & mask) > 0)
                ans.add(~x & mask);
            x <<= 1;
        }
        return ans;
    }

    private int f(int mask, Integer[] nums) {
        if (dp[mask] != null)
            return dp[mask];
        int sum = sum(mask, nums);
        int ans = 0;
        for (int sub: subMask(mask))
            ans = Math.max(ans, (sum == 0 ? 1 : 0) + f(sub, nums));
        return dp[mask] = ans;
    }

    public int minTransfers(int[][] transactions) {
        int[] money = new int[21];
        for (int[] t: transactions) {
            money[t[0]] -= t[2];
            money[t[1]] += t[2];
        }
        Integer[] nums = Arrays.stream(money).filter(x -> x != 0).boxed().toArray(Integer[]::new);
        final int n = nums.length;
        dp = new Integer[1 << n];
        return n - f((1 << n)-1, nums);
    }
}
