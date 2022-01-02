/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.TreeMap;

public class LongestSubArrayWithAbsDiffLessThanEqualToLimit {

    public int longestSubArray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        final int n = nums.length;
        int left = 0, right = 0;
        int len = 0;

        while ( right < n ) {
            while ( !map.isEmpty() && !(Math.abs(map.firstKey() - nums[right]) <= limit && Math.abs(map.lastKey() - nums[right]) <= limit) ) {
                int count = map.get(nums[left]);
                if ( count == 1 ) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], count - 1);
                }
                left++;
            }
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            right++;
            len = Math.max(len, right - left);
        }

        return len;
    }
}
