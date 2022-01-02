/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMaximumMinimumValue {

    public int maximumMinimumPath(int[][] grid) {
        // tuple of (min_value_in_curr_path, i, j)
        int m = grid.length;
        int n = grid[0].length;

        // globally known max score of every cell
        int[][] maxScore = new int[m][n];
        int[][] pos = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        boolean[][] vis = new boolean[m][n];

        // max score of every cell is -INF initially
        for (int[] ms: maxScore)
            Arrays.fill(ms, Integer.MIN_VALUE);

        maxScore[0][0] = grid[0][0];
        pq.add(new int[]{grid[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] tup = pq.poll();
            int currScore = tup[0];
            int i = tup[1];
            int j = tup[2];

            if (vis[i][j])
                continue;

            vis[i][j] = true;

            for (int[] p: pos) {
                int x = p[0]+i;
                int y = p[1]+j;

                if (x >= 0 && x < m && y >= 0 && y < n) {
                    // newScore will be min. score in current path
                    int newScore = Math.min(currScore, grid[x][y]);
                    if (newScore > maxScore[x][y]) {
                        pq.add(new int[]{newScore, x, y});
                        maxScore[x][y] = newScore;
                    }
                }
            }
        }

        return maxScore[m-1][n-1];
    }
}
