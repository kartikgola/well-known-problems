/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {

    private boolean f(List<int[]> emp, int i, int[] ro, int[] co, int[] su, char[][] b) {
        if (i >= emp.size())
            return true;

        int r = emp.get(i)[0];
        int c = emp.get(i)[1];
        int k = (r/3)*3 + (c/3);
        int taken = ro[r] | co[c] | su[k];

        for (int v = 1; v <= 9; ++v) {
            if ((taken & (1 << v)) == 0) {
                b[r][c] = Integer.toString(v).charAt(0);
                ro[r] |= (1 << v);
                co[c] |= (1 << v);
                su[k] |= (1 << v);
                if (f(emp, i+1, ro, co, su, b))
                    return true;
                b[r][c] = '.';
                ro[r] &= ~(1 << v);
                co[c] &= ~(1 << v);
                su[k] &= ~(1 << v);
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        int[] ro = new int[9]; // mask for every row
        int[] co = new int[9]; // mask for every column
        int[] su = new int[9]; // mask for every 3x3 grid
        List<int[]> emp = new ArrayList<>(); // holds empty indices
        for (int k = 0; k < 9; ++k) {
            for (int i = 3*(k/3); i < 3*(k/3)+3; ++i) {
                for (int j = 3*(k%3); j < 3*(k%3)+3; ++j) {
                    if (board[i][j] != '.') {
                        int v = Character.getNumericValue(board[i][j]);
                        ro[i] |= (1 << v); // mark value as taken in row[i]
                        co[j] |= (1 << v); // mark value as taken in column[j]
                        su[k] |= (1 << v); // mark value as taken in 3x3 sub-array[k]
                    } else {
                        emp.add(new int[]{i, j});
                    }
                }
            }
        }

        f(emp, 0, ro, co, su, board);
    }
}
