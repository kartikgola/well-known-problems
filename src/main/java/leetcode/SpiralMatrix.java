/*
 * Author: Kartik Gola
 * Date: 07/07/20, 7:23 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        final int m = matrix.length;
        if ( m == 0 ) return res;
        final int n = matrix[0].length;
        if ( n == 0 ) return res;

        int r1 = 0, r2 = m - 1;
        int c1 = 0, c2 = n - 1;

        while ( r1 <= r2 && c1 <= c2 ) {
            for ( int c = c1; c <= c2; ++c )
                res.add(matrix[r1][c]);
            for ( int r = r1 + 1; r <= r2; ++r )
                res.add(matrix[r][c2]);

            if ( r1 < r2 && c1 < c2 ) {
                for ( int c = c2 - 1; c > c1; --c )
                    res.add(matrix[r2][c]);
                for ( int r = r2; r > r1; --r )
                    res.add(matrix[r][c1]);
            }

            ++r1; --r2;
            ++c1; --c2;
        }

        return res;
    }

}
