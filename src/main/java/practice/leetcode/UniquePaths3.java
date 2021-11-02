/*
 * Author: Kartik Gola
 * Date: 11/2/21, 2:11 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class UniquePaths3 {

    private int dist = 0;
    private int ans = 0;
    private int[][] pos = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};

    private void f(int[][] grid, int curr, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1)
            return;
        if (grid[i][j] == 2) {
            if (curr == dist)
                ans++;
            return;
        }
        grid[i][j] = -1;
        for (int[] p: pos) {
            int x = p[0] + i;
            int y = p[1] + j;
            f(grid, curr+1, x, y);
        }
        grid[i][j] = 0;
    }

    // Approach 1 - DFS
    public int uniquePathsIII(int[][] grid) {
        for (int[] row: grid)
            for (int val: row)
                if (val > -1)
                    dist++;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    // Mark start as 0, to reduce grid states to three (-1,0,2)
                    grid[i][j] = 0;
                    f(grid, 1, i, j);
                    break;
                }
            }
        }
        return ans;
    }

    private class State {
        int i, j;
        int mask;
        int used;
        State(int i, int j, int mask, int used) {
            this.i = i;
            this.j = j;
            this.mask = mask;
            this.used = used;
        }
    }

    // Approach 2 - BFS
    public int uniquePathsIII2(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int dist = 0;
        Queue<State> q = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > -1) {
                    dist++;
                    int idx = i*n+j;
                    if (grid[i][j] == 1)
                        q.add(new State(i, j, 1 << idx, 1));
                }
            }
        }

        int ans = 0;
        int[][] pos = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
        while (!q.isEmpty()) {
            State state = q.poll();
            if (grid[state.i][state.j] == 2) {
                if (state.used == dist)
                    ans++;
                continue;
            }

            for (int[] p: pos) {
                int x = p[0]+state.i;
                int y = p[1]+state.j;
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int idx = x*n+y;
                    if ((state.mask & (1 << idx)) == 0 && (grid[x][y] == 0 || grid[x][y] == 2)) {
                        q.add(new State(x, y, state.mask | (1 << idx), state.used+1));
                    }
                }
            }
        }

        return ans;
    }
}
