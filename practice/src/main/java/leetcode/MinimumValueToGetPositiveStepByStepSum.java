/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class MinimumValueToGetPositiveStepByStepSum {

    public int minStartValue(int[] nums) {
        int count = 0;
        int sum = 0;
        for (int num: nums) {
            sum += num;
            if (sum < 1) {
                count += 1-sum;
                sum = 1;
            }
        }
        return count == 0 ? 1 : count;
    }

    private boolean isFeasible(int[] nums, int x) {
        int sum = x;
        for (int num: nums) {
            sum += num;
            if (sum < 1)
                return false;
        }
        return true;
    }

    public int minStartValue2(int[] nums) {
        int l = 1;
        int r = 100 * nums.length + 1;

        while (l < r) {
            int m = l+(r-l)/2;
            if (isFeasible(nums, m))
                r = m;
            else
                l = m+1;
        }

        return l;
    }
}
