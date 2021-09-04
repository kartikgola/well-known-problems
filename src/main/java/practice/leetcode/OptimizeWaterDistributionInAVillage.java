/*
 * Author: Kartik Gola
 * Date: 9/4/21, 2:06 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import util.ds.disjointset.UnionFind;

import java.util.Arrays;
import java.util.Comparator;

public class OptimizeWaterDistributionInAVillage {

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        UnionFind uf = new UnionFind(n+1);
        int[][] pp = new int[pipes.length + n][3];

        // Add a dummy node(0), that will connect every other node
        for (int i = 0; i < n; ++i)
            pp[i] = new int[]{0, i+1, wells[i]};

        for (int i = n; i < pp.length; ++i)
            pp[i] = pipes[i-n];

        Arrays.sort(pp, Comparator.comparingInt(p -> p[2]));

        int ans = 0;
        for (int[] p: pp) {
            if (uf.union(p[0], p[1])) {
                ans += p[2];
            }
        }

        return ans;
    }
}
