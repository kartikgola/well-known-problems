/*
 * Author: Kartik Gola
 * Date: 4/2/21, 1:10 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: 
 */

package practice.leetcode;

import java.util.*;

public class PathWithMinimumEffort {

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        // tracks known min. effort at [i][j]
        int[][] effort = new int[m][n];
        for (int[] e: effort)
            Arrays.fill(e, Integer.MAX_VALUE);
        effort[0][0] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[0]));
        // tuple of (max. effort in current path, i, j)
        pq.add(new int[]{0, 0, 0});
        boolean[][] vis = new boolean[m][n];
        int[][] pos = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            if (vis[c[1]][c[2]])
                continue;
            vis[c[1]][c[2]] = true;
            for (int[] p: pos) {
                int x = p[0]+c[1];
                int y = p[1]+c[2];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    // can relax only if max {abs. diff, max. effort in current path} < known min. effort at [x][y]
                    if (Math.max(effort[c[1]][c[2]], Math.abs(heights[c[1]][c[2]] - heights[x][y])) < effort[x][y]) {
                        effort[x][y] = Math.max(effort[c[1]][c[2]], Math.abs(heights[c[1]][c[2]] - heights[x][y]));
                        pq.add(new int[]{effort[x][y], x, y});
                    }
                }
            }
        }

        return effort[m-1][n-1];
    }

    public int minimumEffortPathSpfa(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] effort = new int[m][n];
        for (int[] e: effort)
            Arrays.fill(e, Integer.MAX_VALUE);
        effort[0][0] = 0;

        Queue<int[]> q = new LinkedList<>();
        int[][] po = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
        // tuple of (effort, i, j)
        q.add(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] c = q.poll();
            for (int[] p: po) {
                int x = c[1]+p[0];
                int y = c[2]+p[1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (Math.max(c[0], Math.abs(heights[x][y] - heights[c[1]][c[2]])) < effort[x][y]) {
                        effort[x][y] = Math.max(c[0], Math.abs(heights[x][y] - heights[c[1]][c[2]]));
                        q.add(new int[]{effort[x][y], x, y});
                    }
                }
            }
        }
        return effort[m-1][n-1];
    }
}
