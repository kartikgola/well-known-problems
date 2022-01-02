/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

    // O(n) solution
    public boolean checkSubarraySum(int[] nums, int k) {
        final int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{ put(0, -1); }};
        // Store the running modulus sum
        // Whenever we get a mod value, that has been seen before, it means that
        // we have completed 1 (or more) circles in the mod values pie
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            if (nums[i] > 0)
                sum %= k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) >= 2) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }

        }
        return false;
    }
}
