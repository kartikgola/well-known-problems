/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class DeleteAndEarn {

    // Bottom-up DP solution O(nlog(n))
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

    // Bottom-up DP solution O(n)
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

    /*
    * Top-down O(nlogn) DP solution
    * uniq[] is an array of uniques in nums[]
    * counts<int, int> is a count map of nums[]
    * dp[i] = max points that can be earned starting from i, using all/some uniques in [i, n)
    * dp[i] = max {
    *   uniq[i] * counts[i] + (uniq[i+1] == uniq[i] ? dp[i+2] : dp[i+1]),
    *   dp[i+1]
    * }
    * */
    private Integer[] dp;

    private int f(List<Integer> uniq, Map<Integer, Integer> counts, int i) {
        if (i >= uniq.size())
            return 0;

        if (dp[i] != null)
            return dp[i];

        int num = uniq.get(i);
        int count = counts.get(num);
        int points = num * count;

        if (i+1 < uniq.size()) {
            if (uniq.get(i+1) == num+1)
                points += f(uniq, counts, i+2);
            else
                points += f(uniq, counts, i+1);
        }

        return dp[i] = Math.max(points, f(uniq, counts, i+1));
    }

    public int deleteAndEarn3(int[] nums) {
        final int n = nums.length;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num: nums)
            counts.put(num, counts.getOrDefault(num, 0)+1);
        List<Integer> uniq = counts.keySet().stream().sorted().collect(Collectors.toList());
        this.dp = new Integer[uniq.size()];
        return f(uniq, counts, 0);
    }
}
