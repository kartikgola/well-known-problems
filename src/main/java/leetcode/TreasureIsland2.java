/*
 * Author: Kartik Gola
 * Date: 20/06/20, 2:37 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland2 {

    public int treasureIsland2(char[][] grid) {
        final int m = grid.length;
        if ( m == 0 ) return 0;
        final int n = grid[0].length;
        if ( n == 0 ) return 0;

        Queue<int[]> q = new LinkedList<>();
        for ( int i = 0; i < m; ++i ) {
            for ( int j = 0; j < n; ++j ) {
                if ( grid[i][j] == 'S' ) {
                    q.add(new int[]{i, j});
                    // Mark it as visited
                    grid[i][j] = 'D';
                }
            }
        }

        int steps = 0;
        int[][] pos = new int[][]{ {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        while ( !q.isEmpty() ) {
            int sz = q.size();
            while ( sz-- > 0 ) {
                int[] e = q.poll();
                grid[e[0]][e[1]] = 'D';
                for ( int[] p : pos ) {
                    int i = e[0] + p[0], j = e[1] + p[1];
                    if ( i >= 0 && i < m && j >= 0 && j < n ) {
                        if ( grid[i][j] == 'D' ) continue;
                        // First one to reach X wins!
                        if ( grid[i][j] == 'X' ) return steps + 1;
                        q.add(new int[]{i, j});
                    }
                }
            }
            ++steps;
        }

        return steps;
    }
}
