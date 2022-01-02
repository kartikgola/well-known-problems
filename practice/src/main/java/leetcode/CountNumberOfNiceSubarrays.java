/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountNumberOfNiceSubarrays {

    // Technique similar to "Subarray sum equals K"
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(){{ put(0, 1); }};
        int odd = 0;
        int ans = 0;
        for (int x: nums) {
            if (x % 2 != 0)
                odd++;
            int diff = odd - k;
            if (map.containsKey(diff))
                ans += map.get(diff);
            map.put(odd, map.getOrDefault(odd, 0)+1);
        }
        return ans;
    }

    private int atMostK(int[] nums, int k) {
        int l = 0, r = 0;
        int odd = 0;
        int ans = 0;
        while (r < nums.length) {
            if (nums[r] % 2 != 0)
                odd++;
            r++;
            while (odd > k) {
                if (nums[l] % 2 != 0)
                    odd--;
                l++;
            }
            ans += r-l;
        }
        return ans;
    }

    // Subarrays with exactly k odd = subarrays with at most k odd - subarrays with at most k-1 odd
    public int numberOfSubarrays2(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k-1);
    }

}
