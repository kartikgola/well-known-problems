/*
 * Author: Kartik Gola
 * Date: 11/1/21, 5:56 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.Arrays;

public class SurroundedRegions {

    /*

        What is valid region?
            => containing cells are O
            => does not touch border
            => does not touch any INVALID O

        What is INVALID O?
            => Any O that is directly/indirectly touching the border

        Algo
        1. Loop around boundary-O's & run DFS for all O's connecting to boundary-O
            => Mark all these O's as INVALID
        2. Loop in grid & run DFS for all O's that are not INVALID
            => Convert these O's to X
    */

    int[][] pos = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};

    private void markInvalid(char[][] board, boolean[][] valid, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X' || !valid[i][j])
            return;
        valid[i][j] = false;
        for (int[] p: pos) {
            int x = p[0]+i;
            int y = p[1]+j;
            markInvalid(board, valid, x, y);
        }
    }

    private void convertToX(char[][] board, boolean[][] valid, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X' || !valid[i][j])
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
