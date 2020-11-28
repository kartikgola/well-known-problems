/*
 * Author: Kartik Gola
 * Date: 10/11/2020, 20:00
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/running-sum-of-1d-array/
 */

package leetcode;

public class RunningSumOf1DArray {

    public int[] runningSum(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            nums[i] += (i > 0 ? nums[i - 1] : 0);
        }
        return nums;
    }
}
