/*
 * Author: Kartik Gola
 * Date: 10/5/21, 10:57 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostToMakeAtleastOneValidPathInAGrid {

    public int minCost(int[][] grid) {
        final int m = grid.length, n = grid[0].length;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t[0]));

        boolean[][] vis = new boolean[m][n];
        int[][] cost = new int[m][n];
        int[][] pos = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

        for (int[] c: cost)
            Arrays.fill(c, Integer.MAX_VALUE);
        cost[0][0] = 0;

        pq.add(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            if (vis[c[1]][c[2]])
                continue;
            vis[c[1]][c[2]] = true;
            for (int i = 0; i < pos.length; ++i) {
                int x = pos[i][0] + c[1];
                int y = pos[i][1] + c[2];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int newCost = c[0] + (i+1 == grid[c[1]][c[2]] ? 0 : 1);
                    if (newCost < cost[x][y]) {
                        cost[x][y] = newCost;
                        pq.add(new int[]{newCost, x, y});
                    }
                }
            }
        }

        return cost[m-1][n-1];
    }
}
