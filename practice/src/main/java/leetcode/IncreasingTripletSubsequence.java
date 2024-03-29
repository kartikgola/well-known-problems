/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        final int n = nums.length;
        if (n < 3)
            return false;

        boolean[] less = new boolean[n];
        int min = nums[0];
        for (int i = 1; i < n; ++i) {
            less[i] = nums[i] > min;
            min = Math.min(min, nums[i]);
        }

        int max = nums[n - 1];
        for (int i = n - 2; i > -1; --i) {
            if (nums[i] < max && less[i])
                return true;
            max = Math.max(max, nums[i]);
        }

        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num <= firstSmallest) {
                firstSmallest = num;
            } else if (num <= secondSmallest) {
                secondSmallest = num;
            } else {
                return true;
            }
        }
        return false;
    }

}
