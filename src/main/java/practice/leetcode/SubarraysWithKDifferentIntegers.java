/*
 * Author: Kartik Gola
 * Date: 12/18/21, 12:30 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {

    private int atMostKDistinct(int[] nums, int k) {
        int l = 0, r = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            r++;
            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l])-1);
                if (map.get(nums[l]) == 0)
                    map.remove(nums[l]);
                l++;
            }
            // no. of valid subarrays ending at nums[r-1] = r - l
            ans += r - l;
        }
        return ans;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k-1);
    }
}
