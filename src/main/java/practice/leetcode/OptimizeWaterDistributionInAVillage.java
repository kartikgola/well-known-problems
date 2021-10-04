/*
 * Author: Kartik Gola
 * Date: 9/4/21, 2:06 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import util.ds.disjointset.UnionFind;

import java.util.*;

public class OptimizeWaterDistributionInAVillage {

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        UnionFind uf = new UnionFind(n+1);
        int[][] pp = new int[pipes.length + n][3];

        // Add a dummy node(0), that will connect every other node with edge-cost of wells[i]
        // This is useful because in the case below, both house (1) & (2) should have wells
        // And once we've taken (0)-(1) & (0)-(2), we cannot take (1)-(2)
        // (0)--1--(1)
        //  |     /
        //  1    /
        //  |   2
        //  |  /
        //  | /
        // (2)
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

    public int minCostToSupplyWater2(int n, int[] wells, int[][] pipes) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        Queue<int[]> pq = new PriorityQueue<>(n, Comparator.comparingInt(a -> a[0]));
        boolean[] visited = new boolean[n+1];
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            map.putIfAbsent(0, new HashMap<>());
            map.putIfAbsent(i+1, new HashMap<>());
            map.get(0).put(i+1, wells[i]);
            map.get(i+1).put(0, wells[i]);
            pq.add(new int[]{wells[i], i+1});
        }

        for (int[] p: pipes) {
            map.get(p[0]).put(p[1], p[2]);
            map.get(p[1]).put(p[0], p[2]);
        }

        visited[0] = true;
        while (!pq.isEmpty()) {
            int cost = pq.peek()[0];
            int v = pq.poll()[1];

            if (visited[v])
                continue;

            visited[v] = true;
            ans += cost;

            for (Map.Entry<Integer, Integer> e: map.get(v).entrySet()) {
                pq.add(new int[]{e.getValue(), e.getKey()});
            }
        }

        return ans;
    }
}
