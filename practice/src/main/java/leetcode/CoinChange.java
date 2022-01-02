/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;

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
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int amt = 1; amt <= amount; ++amt) {
            for (int i = 0; i < coins.length; ++i) {
                int rem = amt - coins[i];
                if (rem >= 0 && dp[rem] > -1) {
                    dp[amt] = Math.min(dp[amt], 1 + dp[rem]);
                }
            }
            if (dp[amt] == Integer.MAX_VALUE)
                dp[amt] = -1;
        }

        return dp[amount];
    }

}
