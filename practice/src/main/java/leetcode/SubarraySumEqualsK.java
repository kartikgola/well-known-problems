/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int sum = 0;
        // We need to figure out if sum of elements till current (i) equals K
        // So, map will contain = count of no. of times we got sum as 'sum_till_i - K'
        // For each i in len(nums), we keep adding the above count
        Map<Integer, Integer> map = new HashMap<>(){{ put(0, 1); }};
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            int diff = sum-k;
            int count = map.getOrDefault(diff, 0);
            ans += count;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}
