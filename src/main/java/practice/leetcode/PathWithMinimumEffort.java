/*
 * Author: Kartik Gola
 * Date: 4/2/21, 1:10 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/path-with-minimum-effort/
 */

package practice.leetcode;

import java.util.*;

public class PathWithMinimumEffort {

    private class State {
        int i, j;
        int effort; // min effort known in current path
        State(int i, int j, int effort) {
            this.i = i;
            this.j = j;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        final int m = heights.length;
        final int n = heights[0].length;
        int[][] minEffort = new int[m][n];
        for (int[] minEff: minEffort)
            Arrays.fill(minEff, Integer.MAX_VALUE);

        minEffort[0][0] = 0;
        Queue<State> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.effort));
        pq.add(new State(0, 0, 0));
        boolean[][] vis = new boolean[m][n];
        int[][] pos = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};

        while (!pq.isEmpty()) {
            State state = pq.poll();
            if (vis[state.i][state.j])
                continue;
            vis[state.i][state.j] = true;

            for (int[] p: pos) {
                int ni = state.i + p[0];
                int nj = state.j + p[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    int effort = Math.max(state.effort, Math.abs(heights[state.i][state.j] - heights[ni][nj]));
                    if (effort < minEffort[ni][nj]) {
                        minEffort[ni][nj] = effort;
                        pq.add(new State(ni, nj, effort));
                    }
                }
            }
        }

        return minEffort[m-1][n-1];
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
