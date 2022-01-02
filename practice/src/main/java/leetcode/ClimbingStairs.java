/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

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
