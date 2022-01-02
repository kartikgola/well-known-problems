/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {
        final int k = 3;

        if (nums.length < k)
            return false;

        Map<Integer, Integer> counts = new HashMap<>();
        for (int x: nums)
            counts.put(x, counts.getOrDefault(x, 0) + 1);

        Map<Integer, Integer> starts = new HashMap<>();

        // For each x in nums, greedily append it to an existing sequence
        // Else, try to check if a new sequence can be formed starting from x
        // Otherwise, if none of the above 2 things can be done, return false
        for (int x: nums) {
            if (counts.get(x) == 0)
                continue;
            counts.put(x, counts.get(x)-1);
            if (starts.getOrDefault(x, 0) > 0) {
                starts.put(x, starts.get(x)-1);
                starts.put(x+1, starts.getOrDefault(x+1, 0)+1);
            } else {
                for (int y = x+1; y-x+1 <= k; ++y) {
                    if (counts.getOrDefault(y, 0) > 0) {
                        counts.put(y, counts.get(y) - 1);
                    } else return false;
                }
                starts.put(x+k, starts.getOrDefault(x+k, 0)+1);
            }
        }

        return true;
    }
}
