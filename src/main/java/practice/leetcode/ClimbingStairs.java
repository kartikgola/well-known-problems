/*
 * Author: Kartik Gola
 * Date: 27/11/2020, 22:19
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/climbing-stairs/
 */

package practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        if (map.containsKey(n))
            return map.get(n);
        int ways = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, ways);
        return ways;
    }
}
