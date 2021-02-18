/*
 * Author: Kartik Gola
 * Date: 2/16/21, 9:55 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */

package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        final int n = grid.length;
        if ( n == 0 )
            return -1;
        if ( grid[0][0] == 1 || grid[n - 1][n - 1] == 1 )
            return -1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        final int[][] pos = new int[][]{{-1,-1}, {-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;

        while ( !q.isEmpty() ) {
            int[] curr = q.remove();
            // Get the current position
            int i = curr[0],
                j = curr[1],
                dist = curr[2];
            if (i == n - 1 && j == n - 1) return dist;

            for (int[] p : pos) {
                // Next reachable position
                int x = i + p[0],
                    y = j + p[1];
                if (x >= 0 && x < n && y >= 0 && y < n && !vis[x][y] && grid[x][y] == 0) {
                    q.add(new int[]{x, y, dist + 1});
                    vis[x][y]  = true;
                }
            }
        }

        return -1;
    }
}
