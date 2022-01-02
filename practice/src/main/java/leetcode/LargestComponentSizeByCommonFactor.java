/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import disjointset.UnionFind;

import java.util.Arrays;
import java.util.HashMap;

public class LargestComponentSizeByCommonFactor {

    public int largestComponentSize(int[] A) {
        int maxValue = Arrays.stream(A).reduce(A[0], Math::max);
        UnionFind dsu = new UnionFind(maxValue+1);
        for (int x : A) {
            int orig = x;
            // Do trial-division & union(orig, primeFactor)
            int f = 2;
            while (x % 2 == 0) {
                dsu.union(f, orig);
                x /= 2;
            }
            f = 3;
            while (f*f <= x) {
                if (x % f == 0) {
                    dsu.union(f, orig);
                    x /= f;
                } else {
                    f += 2;
                }
            }
            // if num != 1, it is prime in itself. so, we do union of num & temp
            if (x != 1)
                dsu.union(x, orig);
        }

        // count the size of group one by one
        int maxGroupSize = 0;
        HashMap<Integer, Integer> groupCount = new HashMap<>();
        for (int num : A) {
            Integer groupId = dsu.find(num);
            Integer count = groupCount.getOrDefault(groupId, 0);
            groupCount.put(groupId, count+1);
            maxGroupSize = Math.max(maxGroupSize, count+1);
        }

        return maxGroupSize;
    }
}
