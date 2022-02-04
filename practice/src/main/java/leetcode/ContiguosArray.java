/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContiguosArray {

    public int findMaxLength(int[] nums) {
        int[] arr = new int[2 * nums.length + 1];
        Arrays.fill(arr, -2);
        arr[nums.length] = -1;
        int maxLen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 0 ? -1 : 1);
            if (arr[count + nums.length] >= -1) {
                maxLen = Math.max(maxLen, i - arr[count + nums.length]);
            } else {
                arr[count + nums.length] = i;
            }
        }
        return maxLen;
    }

    public int findMaxLength2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(){{ put(0, -1); }};
        int match = 0;
        int ans = 0;

        // Similar logic as Subarray sum equals K
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1)
                match++;
            else match--;

            if (map.containsKey(match)) {
                ans = Math.max(ans, i-map.get(match));
            } else {
                map.put(match, i);
            }
        }

        return ans;
    }

}
