/*
 * Author: Kartik Gola
 * Date: 12/18/20, 12:45 AM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/missing-ranges/
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        int prev = lower;
        for (int num: nums) {
            if (prev < num)
                ans.add(prev == num - 1 ? String.valueOf(prev) : prev + "->" + (num - 1));
            prev = num + 1;
        }
        if (prev <= upper)
            ans.add(prev == upper ? String.valueOf(prev) : prev + "->" + upper);

        return ans;
    }
}
