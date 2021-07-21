/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/4sum-ii/
 */

package practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FourSum2 {

    // Approach:
    // If A+B+C+D = 0, then A+B = -(C+D)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        final Map<Integer, Integer> abMap = new HashMap<>();
        for (int a: A)
            for (int b: B)
                abMap.put(a + b, abMap.getOrDefault(a + b, 0) + 1);

        for (int c: C)
            for (int d: D)
                count += abMap.getOrDefault(-1 * (c + d), 0);

        return count;
    }
}
