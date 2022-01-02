/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class MaxAreaOfIsland {

    int[][] pos = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};

    int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return 0;
        int ans = 1;
        grid[i][j] = 0;
        for (int[] p: pos) {
            ans += dfs(grid, i+p[0], j+p[1]);
        }
        return ans;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }
}
