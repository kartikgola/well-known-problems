/*
 * Author: Kartik Gola
 * Date: 6/22/21, 10:43 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/all-paths-from-source-lead-to-destination/
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceLeadToDestination {

    private boolean leadsToDestination(int u, int dest, List<List<Integer>> adj, boolean[] vis, boolean[] path) {
        if (!vis[u]) {
            vis[u] = path[u] = true;
            for (int v: adj.get(u)) {
                if (!vis[v]) {
                    if (!leadsToDestination(v, dest, adj, vis, path)) // unvisited node should always lead to destination
                        return false;
                } else if (path[v]) { // there is an edge u -> v, such that v is already in the current path
                    return false;
                }
            }
        }
        path[u] = false;
        return u == dest || adj.get(u).size() > 0; // destination is always reachable & non-destination node should have >0 neighbors
    }

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());

        for (int[] e: edges) {
            adj.get(e[0]).add(e[1]);
            if (e[0] == destination) // this check is optional. Having it saves ~3ms :)
                return false;
        }
        return leadsToDestination(source, destination, adj, new boolean[n], new boolean[n]);
    }
}
