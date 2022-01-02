/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteAndEarn {

    // O(nlog(n))
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        final int n = nums.length;
        List<Integer> dp = new ArrayList<>(n);

        // Maintain a count of 'unique' elements
        for (int i = 0, unique = 0; i < n; ++i, ++unique) {
            int j = i;
            while (j+1 < n && nums[j] == nums[j+1])
                ++j;
            int points = nums[i] * (j-i+1);
            if (unique == 1) {
                if (nums[i-1] < nums[i]-1)
                    points += dp.get(dp.size()-1);
            } else if (unique > 1) {
                if (nums[i-1] < nums[i]-1)
                    points += dp.get(dp.size()-1);
                else
                    points += dp.get(dp.size()-2);
            }
            dp.add(Math.max(i > 0 ? dp.get(dp.size()-1) : 0, points));
            i = j;
        }

        return dp.get(dp.size()-1);
    }

    // O(n)
    public int deleteAndEarn2(int[] nums) {
        int[] vals = new int[10001];
        List<Integer> dp = new ArrayList<>(nums.length);
        int prev = -1;

        // Count frequencies
        for (int num: nums)
            vals[num]++;

        // Maintain a count of 'unique' elements
        for (int x = 1, unique = 0; x < vals.length; ++x) {
            if (vals[x] > 0) {
                int points = x * vals[x];
                if (unique == 1) {
                    if (prev < x-1)
                        points += dp.get(dp.size()-1);
                } else if (unique > 1) {
                    if (prev < x-1)
                        points += dp.get(dp.size()-1);
                    else
                        points += dp.get(dp.size()-2);
                }
                // Maximum points till 'x' are added to 'dp'
                dp.add(Math.max(unique == 0 ? 0 : dp.get(dp.size()-1), points));
                prev = x;
                ++unique;
            }
        }

        return dp.get(dp.size() - 1);
    }
}
