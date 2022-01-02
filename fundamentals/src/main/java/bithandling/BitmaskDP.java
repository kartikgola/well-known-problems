/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package bithandling;

public class BitmaskDP {

    private static boolean isPersonAvailable(int assign, int i) {
        return (assign & (1 << i)) == 0;
    }

    private static int assignPerson(int assign, int i) {
        return assign | (1 << i);
    }

    public static int minCostDpTopDown(int job, int assign, int n, int[][] cost, Integer[][] dp) {
        if (job >= n)
            return 0;
        if (dp[job][assign] != null)
            return dp[job][assign];
        int ans = Integer.MAX_VALUE;
        for (int person = 0; person < n; ++person) {
            if (isPersonAvailable(assign, person)) {
                ans = Math.min(ans, cost[person][job] + minCostDpTopDown(job+1, assignPerson(assign, person), n, cost, dp));
            }
        }
        return dp[job][assign] = ans;
    }

    public static int minCostRec(int job, int assign, int n, int[][] cost) {
        if (job >= n)
            return 0;
        int ans = Integer.MAX_VALUE;
        for (int person = 0; person < n; ++person) {
            if (isPersonAvailable(assign, person)) {
                ans = Math.min(ans, cost[person][job] + minCostRec(job+1, assignPerson(assign, person), n, cost));
            }
        }
        return ans;
    }

}
