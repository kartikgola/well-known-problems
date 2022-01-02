/*
 * Author: Kartik Gola
 * Date: 10/5/21, 9:56 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/swim-in-rising-water/
 */

package leetcode;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SwimInRisingWater {

    // Modified Dijkstra approach O(mn * log(mn))
    public int swimInWater(int[][] grid) {
        final int n = grid.length;

        // tuple of (cost_to_reach_cell, i, j)
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // minimum known time to reach cells
        int[][] time = new int[n][n];
        for (int[] ti: time)
            Arrays.fill(ti, Integer.MAX_VALUE);

        boolean[][] vis = new boolean[n][n];
        int[][] pos = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
        pq.add(new int[]{grid[0][0], 0, 0});
        time[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] tup = pq.poll();
            int currTime = tup[0];
            int i = tup[1];
            int j = tup[2];

            if (vis[i][j])
                continue;
            vis[i][j] = true;

            for (int[] po: pos) {
                int x = i+po[0];
                int y = j+po[1];

                if (x >= 0 && x < n && y >= 0 && y < n) {
                    int newTime = Math.max(grid[x][y], currTime);
                    if (newTime < time[x][y]) {
                        pq.add(new int[]{newTime, x, y});
                        time[x][y] = newTime;
                    }
                }
            }
        }

        return time[n-1][n-1];
    }

    private boolean isPossible(int i, int j, int t, int[][] pos, int[][] grid, boolean[][] vis) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] || grid[i][j] > t)
            return false;
        if (i == grid.length-1 && j == grid[0].length-1)
            return true;
        vis[i][j] = true;
        boolean ans = false;
        for (int[] p: pos) {
            if (isPossible(p[0]+i, p[1]+j, t, pos, grid, vis)) {
                ans = true;
                break;
            }
        }
        return ans;
    }

    // Binary-search + DFS approach O(mn * log(mn))
    public int swimInWater2(int[][] grid) {
        final int n = grid.length;
        final int[][] pos = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
        int l = 0;
        int r = n*n;

        while (l < r) {
            int m = l+(r-l)/2;
            if (isPossible(0, 0, m, pos, grid, new boolean[n][n]))
                r = m;
            else
                l = m+1;
        }

        return l;
    }

    // Union-find approach
    private class UF {
        int[] root;
        int[] value;

        UF(int n) {
            this.root = IntStream.range(0, n).toArray();
            this.value = IntStream.range(0, n).map(x -> 1).toArray();
        }

        int find(int u) {
            if (root[u] == u)
                return u;
            return root[u] = find(root[u]);
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if (pu != pv) {
                if (value[pu] >= value[pv]) {
                    value[pu] += value[pv];
                    root[pv] = pu;
                } else {
                    value[pv] += value[pu];
                    root[pu] = pv;
                }
            }
        }
    }

    private class Cell {
        int i, j;
        int val;

        Cell(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    public int swimInWater3(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                cells.add(new Cell(i, j, grid[i][j]));
            }
        }
        cells.sort((c1, c2) -> c1.val - c2.val);
        int[][] pos = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
        boolean[][] vis = new boolean[m][n];
        UF uf = new UF(m*n);

        for (Cell cell: cells) {
            vis[cell.i][cell.j] = true;
            for (int[] p: pos) {
                int ni = p[0] + cell.i;
                int nj = p[1] + cell.j;
                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    if (vis[ni][nj]) {
                        uf.union(cell.i * n + cell.j, ni * n + nj);
                    }
                }
            }

            if (uf.find(0) == uf.find(m*n-1))
                return cell.val;
        }

        return -1;
    }
}
