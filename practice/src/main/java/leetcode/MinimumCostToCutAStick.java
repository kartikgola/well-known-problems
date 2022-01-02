/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumCostToCutAStick {

    private Integer[][] memo;

    /*
        cuts[] ==> sorted([0, ...cuts, n])
        dp[i][j] = min cost to use all cuts in (i, j)
        dp[i][j] = cuts[j] - cuts[i] + min {
            dp[i][k] + dp[k][j]
        }; where, k is in [i+1, j)

        Goal is to find dp[0][cuts.length-1]
    */

    private int cost(int i, int j, List<Integer> cuts) {
        if (j - i <= 1)
            return 0;
        if (memo[i][j] != null)
            return memo[i][j];
        memo[i][j] = Integer.MAX_VALUE;
        for (int k = i+1; k < j; ++k) {
            memo[i][j] = Math.min(
                    memo[i][j],
                    cuts.get(j) - cuts.get(i) + cost(i, k, cuts) + cost(k, j, cuts)
            );
        }
        return memo[i][j];
    }

    public int minCost(int n, int[] cuts) {
        memo = new Integer[102][102];
        List<Integer> _cuts = new ArrayList<>(Arrays.asList(0, n));
        Collections.addAll(Arrays.stream(cuts).boxed().collect(Collectors.toList()));
        Collections.sort(_cuts);
        return cost(0, _cuts.size()-1, _cuts);
    }

}
