/*
 * Author: Kartik Gola
 * Date: 7/18/20 12:59 AM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;

public class SearchA2dMatrix2 {

    private int binarySearch(int[][] mat, int rowFrom, int c, int target) {
        final int m = mat.length;
        final int n = mat[0].length;
        int i = rowFrom, j = m - 1;
        while ( i <= j ) {
            int mid = i + (j - i) / 2;
            if ( mat[mid][c] == target )
                return mid;
            else if ( mat[mid][c] < target ) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -i - 1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        final int m = matrix.length;
        if ( m == 0 ) return false;
        final int n = matrix[0].length;
        if ( n == 0 ) return false;

        int i = 0, j = n - 1;
        while ( i < m && j > -1 ) {
            int num = matrix[i][j];
            if ( num == target ) {
                return true;
            } else if ( num > target && Arrays.binarySearch(matrix[i], 0, j + 1, target) >= 0 ) {
                return true;
            } else if ( num < target && binarySearch(matrix, i, j, target) >= 0 ) {
                return true;
            }
            i++; j--;
        }

        return false;
    }
}
