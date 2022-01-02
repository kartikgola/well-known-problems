/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPathsFromSourceLeadToDestination {

    private boolean f(int u, int x, Map<Integer, List<Integer>> map, Boolean[] dp, boolean[] path) {
        if (path[u])
            return false;
        path[u] = true;
        boolean ans = true;
        // need to check all neighbors of 'u'
        for (int v: map.getOrDefault(u, new ArrayList<>())) {
            // In case this neighbor is already visited (has a defined dp[v]), we can use its result
            if (dp[v] != null)
                ans = dp[v];
            else
                ans = f(v, x, map, dp, path);
            if (!ans)
                break;
        }
        path[u] = false;
        // if there are no outgoing edges, it should be 'x', otherwise return 'ans'
        return dp[u] = map.getOrDefault(u, new ArrayList<>()).isEmpty() ? u == x : ans;
    }

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e: edges) {
            map.putIfAbsent(e[0], new ArrayList<>());
            map.get(e[0]).add(e[1]);
        }
        return f(source, destination, map, new Boolean[n], new boolean[n]);
    }
}
