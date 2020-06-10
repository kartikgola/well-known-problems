/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | rattl.io
 */

package leetcode;

public class CoinChange2 {

    // TODO
    public int coinChange2TopDown(int[] coins, int amount, int j) {
        return -1;
    }

    // Time: O(ca), Space: O(ca)
    public int coinChange2BottomUp(int[] coins, int amount) {
        // ways[i][j] = no. of ways to get amount `j` by using first `i` coins ( or coins[0...i) )
        // So, ways[i][j] = ways that make amount `j` without using `i-1`th coin + ways that make amount `j - coins[i - 1]`
        // or, ways[i][j] = ways[i - 1][j] + ways[i][j - coins[i - 1]]
        int[][] ways = new int[coins.length + 1][amount + 1];
        ways[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            ways[i][0] = 1; // May seem illogical but it is necessary for initial border conditions
            for (int j = 1; j <= amount; j++) {
                // ways that make amount `j` without using `i-1`th coin
                ways[i][j] = ways[i - 1][j];
                // ways that make amount `j - coins[i - 1]`
                ways[i][j] += j >= coins[i - 1] ? ways[i][j - coins[i - 1]] : 0;
            }
        }
        return ways[coins.length][amount];
    }

    // Time: O(ca), Space: O(a)
    public int coinChange2BottomUp2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }

}
