/*
 * Author: Kartik Gola
 * Date: 9/25/21, 5:31 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInAGridWithObstaclesElimination {

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] pos = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, k});
        int[][] vis = new int[m][n];
        for (int[] vi: vis)
            Arrays.fill(vi, -1);
        vis[0][0] = k;
        int dist = 0;

        while (!q.isEmpty()) {
            for (int t = q.size(); t > 0; --t) {
                int[] c = q.poll();
                int i = c[0], j = c[1], l = c[2];
                if (i == m-1 && j == n-1)
                    return dist;
                if (grid[i][j] == 0 || l > 0) {
                    for (int[] p: pos) {
                        int ni = i+p[0];
                        int nj = j+p[1];
                        int nl = grid[i][j] == 1 ? l-1 : l;
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                            if (vis[ni][nj] == -1 || vis[ni][nj] < nl) {
                                vis[ni][nj] = nl;
                                q.add(new int[]{ni, nj, nl});
                            }
                        }
                    }
                }
            }
            ++dist;
        }

        return -1;
    }
}
