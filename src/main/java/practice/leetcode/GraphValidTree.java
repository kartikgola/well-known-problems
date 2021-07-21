/*
 * Author: Kartik Gola
 * Date: 7/26/20 4:19 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {

    private boolean dfs(int u, int parent, List<List<Integer>> adj, boolean[] vis) {
        if ( vis[u] )
            return true;
        vis[u] = true;
        for ( Integer v : adj.get(u) ) {
            if ( v != parent && dfs(v, u, adj, vis) )
                return true;
        }
        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for ( int i = 0; i < n; ++i )
            adj.add(new ArrayList<>());

        for ( int[] edge : edges ) {
            int from = edge[0],
                    to = edge[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        boolean[] vis = new boolean[n];

        // dfs() returns true if there is a back-edge
        if ( dfs(0, -1, adj, vis) )
            return false;

        // We should have no unvisited node left as well
        for ( boolean val : vis )
            if ( !val )
                return false;

        return true;
    }
}
