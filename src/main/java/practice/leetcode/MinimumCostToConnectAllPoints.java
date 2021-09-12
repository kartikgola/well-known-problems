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

    private List<int[]> f(int[][] p, int i, boolean[] vi) {
        List<int[]> al = new ArrayList<>();
        for (int j = 0; j < p.length; ++j) {
            if (j != i && !vi[j]) {
                al.add(new int[]{ Math.abs(p[i][0]-p[j][0]) + Math.abs(p[i][1]-p[j][1]), j });
            }
        }
        return al;
    }

    public int minCostConnectPointsPrims(int[][] p) {
        final int n = p.length;
        boolean[] vi = new boolean[n];
        vi[0] = true;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(p2 -> p2[0]));
        pq.addAll(f(p, 0, vi));
        int ans = 0;
        int count = 0;

        while (!pq.isEmpty() && count < n-1) {
            int[] c = pq.poll();
            if (vi[c[1]])
                continue;
            vi[c[1]] = true;
            count++;
            ans += c[0];
            for (int[] d: f(p, c[1], vi)) {
                pq.add(new int[]{d[0], d[1]});
            }
        }

        return ans;
    }
}
