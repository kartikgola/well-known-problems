/*
 * Author: Kartik Gola
 * Date: 6/18/21, 12:41 AM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/shortest-distance-to-target-color/
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistanceToTargetColor {

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        final int n = colors.length;
        int[][] last = new int[3+1][n];

        for (int c = 1; c <= 3; ++c) {
            last[c][0] = colors[0] == c ? 0 : -1;
            for (int i = 1; i < n; ++i)
                last[c][i] = colors[i] == c ? i : last[c][i-1];

            last[c][n-1] = colors[n-1] == c ? n-1 : last[c][n-1];
            for (int i = n-2; i >= 0; --i) {
                if (last[c][i+1] != -1) {
                    if (last[c][i] == -1)
                        last[c][i] = last[c][i+1];
                    else
                        last[c][i] = i-last[c][i] < last[c][i+1]-i ? last[c][i] : last[c][i+1];
                }
            }
        }

        List<Integer> ans = new ArrayList<>(queries.length);
        for (int[] q: queries)
            ans.add(last[q[1]][q[0]] != -1 ? Math.abs(q[0] - last[q[1]][q[0]]) : last[q[1]][q[0]]);

        return ans;
    }
}
