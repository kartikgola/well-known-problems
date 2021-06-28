/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GameOfLife {

    private int getLiveNeighbours(int[][] board, int i, int j) {
        final int m = board.length;
        final int n = board[0].length;
        int live = 0;
        for ( int k = i - 1; k <= i + 1; ++k ) {
            if ( k > -1 && k < m ) {
                for ( int l = j - 1; l <= j + 1; ++l ) {
                    if ( l > -1 && l < n && board[k][l] > 0 )
                        ++live;
                }
            }
        }
        return board[i][j] == 1 ? live - 1 : live;
    }

    // With O(mn) space
    private void gameOfLife(int[][] board) {
        final int m = board.length;
        final int n = board[0].length;
        int[][] copyBoard = new int[m][n];

        // Create board copy
        for ( int i = 0; i < m; ++i ) {
            System.arraycopy(board[i], 0, copyBoard[i], 0, n);
        }

        int liveNeighbours;
        // Main program logic
        for ( int i = 0; i < m; ++i ) {
            for ( int j = 0; j < n; ++j ) {
                liveNeighbours = getLiveNeighbours(board, i, j);
                if ( board[i][j] == 1 && (liveNeighbours < 2 || liveNeighbours > 3))
                    copyBoard[i][j] = 0;
                else if ( board[i][j] == 0 && liveNeighbours == 3 )
                    copyBoard[i][j] = 1;
            }
        }

        // copy the values back to original board
        for ( int i = 0; i < m; ++i ) {
            for ( int j = 0; j < n; ++j ) {
                board[i][j] = copyBoard[i][j];
            }
        }
    }

    // With O(1) space
    public void gameOfLife2(int[][] board) {
        final int m = board.length;
        final int n = board[0].length;

        int liveNeighbours;
        // Main program logic
        for ( int i = 0; i < m; ++i ) {
            for ( int j = 0; j < n; ++j ) {
                liveNeighbours = getLiveNeighbours(board, i, j);
                if ( board[i][j] == 1 && (liveNeighbours < 2 || liveNeighbours > 3))
                    board[i][j] = 2; // 2 means that this guy will die in next gen
                else if ( board[i][j] == 0 && liveNeighbours == 3 )
                    board[i][j] = -1; // -1 means that this guy will live in next gen
            }
        }

        // copy the values back to original board
        for ( int i = 0; i < m; ++i ) {
            for ( int j = 0; j < n; ++j ) {
                if ( board[i][j] == 2 ) board[i][j] = 0;
                else if ( board[i][j] == -1 ) board[i][j] = 1;
            }
        }
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0},
        };
        gameOfLife(board);
        
        for ( int[] row : board ) {
            System.out.println(Arrays.toString(row));
        }
    }
}
