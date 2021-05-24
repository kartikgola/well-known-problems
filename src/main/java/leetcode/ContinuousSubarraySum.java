/*
 * Author: Kartik Gola
 * Date: 5/24/21, 12:28 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/continuous-subarray-sum/
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        final int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{ put(0, -1); }};
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
