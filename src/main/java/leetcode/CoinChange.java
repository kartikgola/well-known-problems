/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import java.util.Arrays;

public class CoinChange {

    private int _change(int[] map, int[] coins, int amount) {
        if ( amount < 0 )
            return -1;

        if ( amount == 0 )
            return 0;

        if ( map[amount] != Integer.MAX_VALUE )
            return map[amount];

        int coinsNeeded = Integer.MAX_VALUE;
        for ( int coin : coins ) {
            int subCoinsNeeded = _change(map, coins, amount - coin);
            if ( subCoinsNeeded >= 0 ) {
                coinsNeeded = Math.min(coinsNeeded, subCoinsNeeded + 1);
            }
        }

        return map[amount] = coinsNeeded == Integer.MAX_VALUE ? -1 : coinsNeeded;
    }

    public int coinChangeTopDown(int[] coins, int amount) {
        int[] map = new int[amount + 1];
        Arrays.fill(map, Integer.MAX_VALUE);
        return _change(map, coins, amount);
    }

    public int coinChangeBottomUp(int[] coins, int amount) {
        int[] map = new int[amount + 1];
        map[0] = 0;

        for ( int a = 1; a <= amount; ++a ) {
            map[a] = Integer.MAX_VALUE;
            for ( int coin : coins ) {
                if (a - coin >= 0 && map[a - coin] > -1) {
                    map[a] = Math.min(map[a], map[a - coin] + 1);
                }
            }
            map[a] = map[a] == Integer.MAX_VALUE ? -1 : map[a];
        }

        return map[amount];
    }

}
