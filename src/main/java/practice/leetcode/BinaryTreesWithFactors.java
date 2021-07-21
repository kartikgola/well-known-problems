/*
 * Author: Kartik Gola
 * Date: 14/03/2021, 13:37
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/binary-trees-with-factors/
 */

package practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreesWithFactors {

    public int numFactoredBinaryTrees(int[] arr) {
        final int n = arr.length;
        final int MOD = 1000_000_007;
        final Map<Integer, Long> map = new HashMap<>();
        for (int num: arr) map.put(num, 1L);

        // Example, arr = [2,4,5,25,100]
        // Sorting is necessary because for prepare result of 100
        // we should be knowing the result of 4 and 25
        Arrays.sort(arr);
        int totalTrees = 0;

        for (int i = 0; i < n; ++i) {
            long trees = 1L;
            for (int j = 0; j < i; ++j) {
                // let arr[i] = 100, arr[j] = 4, then arr[i]/arr[j] = 25
                // So, trees(100) = trees(4) * trees(25)
                // Also, we add 1 to trees(100) because it can also exist as a single root
                if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j]))
                    trees += (map.get(arr[j]) * map.get(arr[i] / arr[j]));
            }
            map.put(arr[i], trees);
            totalTrees += (int) (trees % MOD);
            totalTrees %= MOD;
        }

        return totalTrees;
    }
}
