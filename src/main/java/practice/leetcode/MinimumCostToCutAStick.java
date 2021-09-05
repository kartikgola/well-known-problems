/*
 * Author: Kartik Gola
 * Date: 9/5/21, 12:53 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumCostToCutAStick {

    private Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();

    private int cost(int l, int r, int[] cuts) {
        if (r - l <= 1)
            return 0;

        if (dp.containsKey(l) && dp.get(l).containsKey(r))
            return dp.get(l).get(r);

        int ans = Integer.MAX_VALUE;
        for (int cut: cuts) {
            if (cut > l && cut < r) {
                int subCost = cost(l, cut, cuts) + cost(cut, r, cuts);
                ans = Math.min(ans, subCost + r - l);
            }
        }

        if (ans == Integer.MAX_VALUE)
            ans = 0;

        dp.putIfAbsent(l, new HashMap<>());
        dp.get(l).put(r, ans);

        return ans;
    }

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        return cost(0, n, cuts);
    }
}
