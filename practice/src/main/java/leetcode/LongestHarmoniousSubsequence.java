/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
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
            ans = Math.max(ans, Math.max(map.getOrDefault(num - 1, -count), map.getOrDefault(num + 1, -count)) + count);
        }
        return ans;
    }
}
