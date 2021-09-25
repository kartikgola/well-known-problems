/*
 * Author: Kartik Gola
 * Date: 9/25/21, 1:25 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {

    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // tuple of (dist, i, j, start_i, start_j)
        Queue<int[]> q = new LinkedList<>();

        int buildings = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    q.add(new int[]{0, i, j, i, j});
                    buildings++;
                }
            }
        }

        // Every value is a tuple of (sum of min. distances from buildings, total buildings reachable)
        int[][][] dist = new int[m][n][2];
        boolean[][][][] vis = new boolean[m][n][m][n];
        int[][] pos = new int[][]{{0,-1}, {-1,0}, {0,1},{1,0}};

        while (!q.isEmpty()) {
            int[] c = q.poll();
            int d = c[0], i = c[1], j = c[2], si = c[3], sj = c[4];

            // pass if visited or obstacle
            if (vis[si][sj][i][j] || grid[i][j] == 2)
                continue;

            // store distance if empty
            if (grid[i][j] == 0) {
                dist[i][j][0] += d;
                dist[i][j][1]++;
            }

            vis[si][sj][i][j] = true;
            if (grid[i][j] == 0 || (si == i && sj == j)) {
                for (int[] po: pos) {
                    int ni = i+po[0];
                    int nj = j+po[1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                        q.add(new int[]{d+1, ni, nj, si, sj});
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dist[i][j][1] == buildings) {
                    ans = Math.min(ans, dist[i][j][0]);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
