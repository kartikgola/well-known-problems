/*
 * Author: Kartik Gola
 * Date: 20/06/20, 12:04 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {

    static class Pair {
        int i, j, d;
        Pair(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }

    public int treasureIslandBFS(char[][] grid) {
        final int m = grid.length;
        if ( m == 0 ) return 0;
        final int n = grid[0].length;
        if ( n == 0 ) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 0));

        while ( !q.isEmpty() ) {
            Pair pr = q.poll();
            int i = pr.i, j = pr.j, d = pr.d;

            if ( i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 'D' )
                continue;

            if ( grid[i][j] == 'X' )
                return d;

            grid[i][j] = 'D';
            int[][] pos = new int[][]{ {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
            for ( int[] p : pos ) {
                q.add(new Pair(i + p[0], j + p[1], d + 1));
            }
        }

        return -1;
    }
}
