/*
 * Author: Kartik Gola
 * Date: 5/24/21, 12:51 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/knight-dialer/
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KnightDialer {

    private final int[][] offsets = new int[][]{ {-2,-1}, {-2,1}, {-1,2}, {1, 2}, {2,1}, {2,-1}, {1,-2}, {-1,-2} };

    public int knightDialer(int n) {
        // Set of moves from keys 0...9
        List<Set<Integer>> moves = new ArrayList<>(10);
        final int MOD = 1000_000_007;
        int[][] dp = new int[n+1][10];
        int ans = 0;

        for (int key = 0; key <= 9; ++key) {
            int i = (key-1)/3, j = (key-1)%3;
            if (key == 0) {
                i = 3;
                j = 1;
            }
            moves.add(new HashSet<>(3));
            for (int[] off: offsets) {
                int x = i + off[0];
                int y = j + off[1];
                if (x >= 0 && x <= 3 && y >= 0 && y <= 2 && !(x == 3 && y == 0) && !(x == 3 && y == 2)) {
                    moves.get(key).add((x == 3 && y == 1) ? 0 : 3 * x + y + 1);
                }
            }
        }

        // For each move in [1..n]
        for (int move = 1; move <= n; ++move) {
            // For each key in [0..9]
            for (int key = 0; key <= 9; ++key) {
                if (move == 1) {
                    dp[move][key] = 1;
                } else {
                    for (int next : moves.get(key)) {
                        dp[move][key] += dp[move - 1][next];
                        dp[move][key] %= MOD;
                    }
                }
                // Answer is the sum of all possible positions from the last move
                if (move == n) {
                    ans += dp[move][key];
                    ans %= MOD;
                }
            }
        }

        return ans;
    }
}
