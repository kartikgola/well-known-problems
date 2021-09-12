/*
 * Author: Kartik Gola
 * Date: 9/12/21, 9:00 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import util.ds.disjointset.UnionFind;

import java.util.*;

public class MinimumCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] p) {
        List<int[]> al = new ArrayList<>(p.length);
        Queue<int[]> pq = new PriorityQueue<>(p.length, Comparator.comparingInt(e -> e[2]));
        for (int i = 0; i < p.length; ++i) {
            for (int j = i+1; j < p.length; ++j) {
                pq.add(new int[]{i, j, Math.abs(p[i][0]-p[j][0]) + Math.abs(p[i][1]-p[j][1])});
            }
        }
        UnionFind uf = new UnionFind(p.length);
        int ans = 0;
        int edges = 0;
        while (!pq.isEmpty() && edges < p.length-1) {
            int[] e = pq.poll();
            if (uf.union(e[0], e[1])) {
                ans += e[2];
                edges++;
            }
        }
        return ans;
    }
}
