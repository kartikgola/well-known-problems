/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/coin-change/
 */

package practice.leetcode;

public class CoinChange {

    private int coinChangeTopDown(Integer[] map, int[] coins, int amount) {
        if ( amount < 0 )
            return -1;

        if ( amount == 0 )
            return 0;

        if ( map[amount] != null )
            return map[amount];

        int coinsNeeded = Integer.MAX_VALUE;
        for ( int coin : coins ) {
            int subCoinsNeeded = coinChangeTopDown(map, coins, amount - coin);
            if ( subCoinsNeeded >= 0 ) {
                coinsNeeded = Math.min(coinsNeeded, subCoinsNeeded + 1);
            }
        }

        return map[amount] = coinsNeeded == Integer.MAX_VALUE ? -1 : coinsNeeded;
    }

    public int coinChangeTopDown(int[] coins, int amount) {
        Integer[] map = new Integer[amount + 1];
        return coinChangeTopDown(map, coins, amount);
    }

    public int coinChangeBottomUp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int amt = 1; amt <= amount; ++amt) {
            dp[amt] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (amt - coin >= 0 && dp[amt - coin] > -1) {
                    dp[amt] = Math.min(dp[amt], dp[amt - coin] + 1);
                }
            }
            dp[amt] = dp[amt] == Integer.MAX_VALUE ? -1 : dp[amt];
        }

        return dp[amount];
    }

}
