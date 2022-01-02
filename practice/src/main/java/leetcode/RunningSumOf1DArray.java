/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
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
