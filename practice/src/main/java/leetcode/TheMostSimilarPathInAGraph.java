/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class TheMostSimilarPathInAGraph {

    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] tp) {
        final int m = tp.length;
        List<Integer> ans = new ArrayList<>();
        Map<Integer, List<Integer>> rmap = new HashMap<>();
        for (int[] r: roads) {
            rmap.putIfAbsent(r[0], new ArrayList<>());
            rmap.putIfAbsent(r[1], new ArrayList<>());
            rmap.get(r[0]).add(r[1]);
            rmap.get(r[1]).add(r[0]);
        }

        // dp[i][j] = min edit distance ending on road 'i' and targetPath 'j'
        // Overall min edit distance will be given by min { dp[k][m-1] }, for all k in [0, n-1]
        int[][] dp = new int[n][m];
        // pr[i][j] = index of prev. road that forms min edit distance
        int[][] pr = new int[n][m];

        // Base case
        for (int i = 0; i < n; ++i) {
            dp[i][0] = names[i].equals(tp[0]) ? 0 : 1;
            pr[i][0] = -1;
        }

        // Fill up the table starting from col 1, for all rows
        for (int j = 1; j < tp.length; ++j) {
            for (int i = 0; i < n; ++i) {
                // neighboring road which offers least edit distance
                int l = -1;
                for (int k: rmap.get(i)) {
                    if (l == -1 || dp[k][j-1] < dp[l][j-1])
                        l = k;
                }
                pr[i][j] = l;
                dp[i][j] = dp[l][j-1] + (names[i].equals(tp[j]) ? 0 : 1);
            }
        }

        // Find min edit distance road in dp[i][m-1], for i in [0, n-1]
        int prevRoad = 0;
        for (int i = 0; i < n; ++i) {
            if (dp[i][tp.length-1] < dp[prevRoad][tp.length-1])
                prevRoad = i;
        }

        // since pr[][] contains pointers to previous roads
        // we can easily populate ans
        for (int j = tp.length-1; j >= 0; --j) {
            ans.add(prevRoad);
            prevRoad = pr[prevRoad][j];
        }

        Collections.reverse(ans);
        return ans;
    }
}
