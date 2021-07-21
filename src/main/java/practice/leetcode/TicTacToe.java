/*
 * Author: Kartik Gola
 * Date: 24/07/20, 7:25 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/design-tic-tac-toe
 */

package practice.leetcode;

public class TicTacToe {

    int[][] moves;
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        // Moves is an array of dimension [3, 2n+2]
        // Rows are 3 just to ease indexing of Player 1 & 2
        // Columns are n(sum of each row) + n(sum of each column) + 2(sum of 2 diagonals)
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
        // Maximum sum of markers of each row/column/diagonal
        int sum = 0;

        // Update the rows & cols moves
        sum = Math.max(++moves[player][row], sum);
        sum = Math.max(++moves[player][col + n], sum);

        // Update the main diagonal moves
        if ( row == col )
            sum = Math.max(++moves[player][moves[player].length - 2], sum);

        // Update the off diagonal moves
        if ( row + col == n - 1 )
            sum = Math.max(++moves[player][moves[player].length - 1], sum);

        return sum == n ? player : 0;
    }
}