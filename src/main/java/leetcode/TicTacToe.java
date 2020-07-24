/*
 * Author: Kartik Gola
 * Date: 24/07/20, 7:25 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/design-tic-tac-toe
 */

package leetcode;

public class TicTacToe {

    int[][] moves;
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        this.moves = new int[2 + 1][2 * n + 2];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        // number of markers in each row/col/diag
        int res = 0;

        // update the rows & cols count
        res = Math.max(++moves[player][row], res);
        res = Math.max(++moves[player][col + n], res);

        // update the main diagonal
        if ( row == col )
            res = Math.max(++moves[player][moves[player].length - 2], res);

        // update the off diagonal
        if ( row + col == n - 1 )
            res = Math.max(++moves[player][moves[player].length - 1], res);

        return res == n ? player : 0;
    }
}