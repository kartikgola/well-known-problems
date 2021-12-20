/*
 * Author: Kartik Gola
 * Date: 12/20/21, 10:33 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class CandyCrush {

    public int[][] candyCrush(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean canCrush = true;

        while (canCrush) {
            canCrush = false;

            int[][] copy = new int[m][n];
            for (int i = 0; i < m; ++i)
                copy[i] = board[i].clone();

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    int val = board[i][j];
                    if (val > 0) {
                        // check horizontal
                        int l = j, r = j;
                        while (l-1 >= 0 && board[i][l-1] == val)
                            l--;

                        while (r+1 < n && board[i][r+1] == val)
                            r++;

                        if (r-l+1 >= 3) {
                            canCrush =  true;
                            while (l <= r) {
                                copy[i][l++] = 0;
                                copy[i][r--] = 0;
                            }
                        }

                        // check vertical
                        int t = i, b = i;
                        while (t-1 >= 0 && board[t-1][j] == val)
                            t--;

                        while (b+1 < m && board[b+1][j] == val)
                            b++;

                        if (b-t+1 >= 3) {
                            canCrush = true;
                            while (t <= b) {
                                copy[t++][j] = 0;
                                copy[b--][j] = 0;
                            }
                        }
                    }
                }
            }

            // Perform crush
            if (canCrush) {
                for (int j = 0; j < n; ++j) {
                    // position of first 0
                    int k = m-1;
                    // if any value is > 0, swap it with [k][j]
                    for (int i = m-1; i >= 0; --i) {
                        if (copy[i][j] > 0) {
                            copy[k--][j] = copy[i][j];
                        }
                    }
                    // fill zeros in left over
                    while (k >= 0) {
                        copy[k--][j] = 0;
                    }
                }
            }

            board = copy;
        }

        return board;
    }
}
