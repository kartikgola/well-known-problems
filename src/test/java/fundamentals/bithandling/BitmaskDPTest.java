/*
 * Author: Kartik Gola
 * Date: 7/21/21, 4:51 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package fundamentals.bithandling;

import org.junit.jupiter.api.Test;

import java.util.Random;

class BitmaskDPTest {

    static final Random rand = new Random(44);

    @Test
    void testBitmaskDP() {
        final int n = 11;
        final int[][] cost = new int[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                cost[i][j] = rand.nextInt(10);

        Integer[][] dp = new Integer[n][(int) Math.pow(2, n)];
        long start = System.currentTimeMillis();
        int ans = BitmaskDP.minCostDp(0, 0, n, cost, dp);
        System.out.println("Min. cost with DP = " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        ans = BitmaskDP.minCostRec(0, 0, n, cost);
        System.out.println("Min. cost without DP = " + (System.currentTimeMillis() - start));
    }

}