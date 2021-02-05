/*
 * Author: Kartik Gola
 * Date: 05/02/2021, 12:31
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/longest-harmonious-subsequence/
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
            // For a given number, we should have >=1 count of either number-1 or number+1
            // We get the maximum count of number-1 and number+1 and update ans
            ans = Math.max(ans,
                    Math.max(map.getOrDefault(num - 1, -count), map.getOrDefault(num + 1, -count)) + count);
        }
        return ans;
    }
}
