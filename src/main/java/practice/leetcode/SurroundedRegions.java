/*
 * Author: Kartik Gola
 * Date: 11/1/21, 5:56 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.Arrays;

public class SurroundedRegions {

    /*

        Region should not be touching any border
        If region is OK,
            flip all O => X

        What is OK?
            => does not touch border
            => does not touch any invalid(visited) O

        Loop around boundary cells & run DFS for all O's in boundary
            => Mark all reachable O's invalid
        Loop entire grid & make valid O's as X's
    */

    int[][] pos = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};

    private void markInvalid(char[][] board, boolean[][] valid, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        if (board[i][j] == 'X')
            return;
        if (!valid[i][j])
            return;
        valid[i][j] = false;
        for (int[] p: pos) {
            int x = p[0]+i;
            int y = p[1]+j;
            markInvalid(board, valid, x, y);
        }
    }

    private void convertToX(char[][] board, boolean[][] valid, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        if (board[i][j] == 'X')
            return;
        if (!valid[i][j])
            return;
        board[i][j] = 'X';
        for (int[] p: pos) {
            int x = p[0]+i;
            int y = p[1]+j;
            convertToX(board, valid, x, y);
        }
    }

    public void solve(char[][] board) {
        final int m = board.length;
        final int n = board[0].length;
        boolean[][] valid = new boolean[m][n];
        for (boolean[] v: valid)
            Arrays.fill(v, true);

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0 || i == m-1 || j == n-1) {
                    // If a boundary O is valid, do a DFS and make all connecting O's invalid
                    if (board[i][j] == 'O' && valid[i][j]) {
                        markInvalid(board, valid, i, j);
                    }
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O' && valid[i][j]) {
                    // Remaining valid O's should be converted to X
                    convertToX(board, valid, i, j);
                }
            }
        }
    }
}
