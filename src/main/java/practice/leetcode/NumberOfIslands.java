/*
 * Author: Kartik Gola
 * Date: 19/06/20, 7:27 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

public class NumberOfIslands {

    char[][] g;
    int m;
    int n;

    private void visit(int i, int j) {
        if ( i < 0 || j < 0 || i >= m || j >= n || g[i][j] == '0' )
            return;
        g[i][j] = '0';
        visit(i - 1, j);
        visit(i + 1, j);
        visit(i, j + 1);
        visit(i, j - 1);
    }

    public int numIslands(char[][] grid) {
        m = grid.length;
        if ( m == 0 ) return 0;
        n = grid[0].length;
        if ( n == 0 ) return 0;
        g = grid;

        int c = 0;

        for ( int i = 0; i < m; ++i ) {
            for ( int j = 0; j < n; ++j ) {
                if ( grid[i][j] == '1') {
                    visit(i, j);
                    ++c;
                }
            }
        }

        return c;
    }
}
