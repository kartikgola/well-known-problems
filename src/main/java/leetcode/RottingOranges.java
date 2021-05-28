/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import util.Pair;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        boolean[][] v = new boolean[m][n];
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        for ( int i = 0; i < m; ++i ) {
            for ( int j = 0; j < n; ++j ) {
                if ( grid[i][j] == 2 ) {
                    v[i][j] = true;
                    if ( i > 0 && grid[i - 1][j] == 1 && !v[i - 1][j] ) {
                        q.add( new Pair<>(i - 1, j) );
                        v[i - 1][j] = true;
                    }

                    if ( j < n - 1 && grid[i][j + 1] == 1 && !v[i][j + 1] ) {
                        q.add( new Pair<>(i, j + 1) );
                        v[i][j + 1] = true;
                    }

                    if ( i < m - 1 && grid[i + 1][j] == 1 && !v[i + 1][j] ) {
                        q.add( new Pair<>(i + 1, j) );
                        v[i + 1][j] = true;
                    }

                    if ( j > 0 && grid[i][j - 1] == 1 && !v[i][j - 1] ) {
                        q.add( new Pair<>(i, j - 1) );
                        v[i][j - 1] = true;
                    }
                }
            }
        }

        if ( !q.isEmpty() )
            q.add(null);

        int minute = 0;
        while ( !q.isEmpty() ) {
            Pair<Integer, Integer> p = q.poll();
            if ( p == null ) {
                ++minute;
                if ( q.isEmpty() ) break;
                else q.add(null);
            } else {
                int i = p.getKey(), j = p.getValue();
                grid[i][j] = 2;
                v[i][j] = true;
                if ( i > 0 && grid[i - 1][j] == 1 && !v[i - 1][j] ) {
                    q.add( new Pair<>(i - 1, j) );
                    v[i - 1][j] = true;
                }

                if ( j < n - 1 && grid[i][j + 1] == 1 && !v[i][j + 1] ) {
                    q.add( new Pair<>(i, j + 1) );
                    v[i][j + 1] = true;
                }

                if ( i < m - 1 && grid[i + 1][j] == 1 && !v[i + 1][j] ) {
                    q.add( new Pair<>(i + 1, j) );
                    v[i + 1][j] = true;
                }

                if ( j > 0 && grid[i][j - 1] == 1 && !v[i][j - 1] ) {
                    q.add( new Pair<>(i, j - 1) );
                    v[i][j - 1] = true;
                }
            }
        }

        for ( int[] row : grid ) {
            for ( int item : row ) {
                if ( item == 1 )
                    return -1;
            }
        }

        return minute;
    }

}
