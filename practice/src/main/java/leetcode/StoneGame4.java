/*
 * Author: Kartik Gola
 * Date: 1/22/22, 11:47 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class StoneGame4 {

    private boolean f(int n, Map<Integer, Boolean> memo) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;
        if (memo.containsKey(n))
            return memo.get(n);
        for (int i = 1; i <= (int)Math.sqrt(n); ++i) {
            if (!f(n - i*i, memo)) {
                memo.put(n, true);
                return true;
            }
        }
        memo.put(n, false);
        return false;
    }

    public boolean winnerSquareGame(int n) {
        return f(n, new HashMap<>());
    }

    public boolean winnerSquareGame2(int n) {
        // dp[i] = true, if the player starting turn at 'i' stones can win
        boolean[] dp = new boolean[n+1];
        dp[0] = false;

        outer:
        for (int i = 1; i <= n; ++i) {
            final int maxSquare = (int) Math.sqrt(i);
            for (int j = 1; j <= maxSquare; ++j) {
                // current player can win from 'i' stones, if opponent is losing using 'i - j*j' stones
                // where j is in [1, sqrt(i)]
                if (!dp[i - j*j]) {
                    dp[i] = true;
                    continue outer;
                }
            }
            dp[i] = false;
        }

        return dp[n];
    }
}
