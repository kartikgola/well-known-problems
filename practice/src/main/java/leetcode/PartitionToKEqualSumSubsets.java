/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {

    private boolean canPart(int mask, int[] nums, int end, int k, int currSum, int partSum) {
        if (k == 0)
            return true;
        if (currSum == partSum)
            if (canPart(mask, nums, nums.length-1, k-1, 0, partSum))
                return true;
        for (int i = end; i >= 0; --i) {
            if ((mask & (1 << i)) == 0) {
                if (currSum + nums[i] <= partSum) {
                    mask |= (1 << i);
                    if (canPart(mask, nums, i-1, k, currSum + nums[i], partSum))
                        return true;
                    mask &= ~(1 << i);
                }
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int x: nums)
            sum += x;
        if (sum % k != 0)
            return false;
        Arrays.sort(nums);
        return canPart(0, nums, nums.length-1, k, 0, sum / k);
    }

}
