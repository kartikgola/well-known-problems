/*
 * Author: Kartik Gola
 * Date: 8/12/20 7:38 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/pascals-triangle-ii/
 */

package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalsTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        int[] dp = new int[rowIndex + 1];
        dp[0] = 1;
        for ( int row = 1; row <= rowIndex; ++row ) {
            int prev = -1;
            for ( int i = 0; i < row + 1; ++i ) {
                // Ends are always 1
                if ( i == 0 || i == row ) {
                    dp[i] = prev = 1;
                } else {
                    // Any other index will be dp[i] = prev + dp[i]
                    int temp = dp[i];
                    dp[i] += prev;
                    prev = temp;
                }
            }
        }
        return Arrays.stream(dp).boxed().collect(Collectors.toList());
    }
}
