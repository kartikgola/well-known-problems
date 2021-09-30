/*
 * Author: Kartik Gola
 * Date: 8/6/21, 12:09 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/stone-game/
 */

package practice.leetcode;

public class StoneGame {

    /**
     * n = piles.length
     * dp[i][j] = max score "ALEX" can get using piles[i..j]
     * we need to find dp[0][n-1]
     *
     * The term "score" always denotes Alex's score
     * Alex will try to maximize the score
     * Bob will try to minimize the score
     *
     * For Alex,
     * dp[i][j] = max{ p[i] + dp[i+1][j], p[j] + dp[i][j-1] }
     * For Bob,
     * dp[i][j] = min{ -p[i] + dp[i+1][j], -p[j] + dp[i][j-1] }
     *
     * How to turn who's turn it is ?
     * Alex will always play on even number of piles
     * So, the difference of indices will be odd
     * Example, [1,2,3,4] => diff = 3-0 = 3
     * if j-i % 2 != 0:
     *  => Alex's turn
     */

    public boolean stoneGame(int[] piles) {
        final int n = piles.length;
        int[][] dp = new int[n][n];

        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n-k; ++i) {
                int j = i+k;
                boolean alexTurn = (j-i) % 2 != 0;
                if (i == j)
                    dp[i][j] = (alexTurn ? 1 : -1) * piles[i];
                else if (alexTurn)
                    dp[i][j] = Math.max( piles[i] + dp[i+1][j], piles[j] + dp[i][j-1] );
                else
                    dp[i][j] = Math.min( -piles[i] + dp[i+1][j], -piles[j] + dp[i][j-1] );
            }
        }

        return dp[0][n-1] > 0;
    }

}
