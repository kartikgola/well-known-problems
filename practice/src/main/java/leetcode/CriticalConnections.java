/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnections {

    int time = 0;

    // Tarjan's algorithm to find "cutEdges" in a graph
    // Bridge is any edge that if removed causes the graph to become disconnected
    // So, if "u-v" is a bridge, then after removing it, the vertices "u" and "v" will not be reachable from each other.
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // discovery time of vertex u
        int[] disc = new int[n];
        // lowest vertex reachable by u
        int[] low = new int[n];
        // List of cut-vertices's edges
        List<List<Integer>> cv = new ArrayList<>();
        // Adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for ( int i = 0; i < n; ++i )
            adj.add( new ArrayList<>() );

        for ( List<Integer> conn : connections ) {
            int from = conn.get(0);
            int to = conn.get(1);

            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        // Make all vertices unvisited
        for ( int i = 0; i < n; ++i )
            disc[i] = -1;

        for ( int i = 0; i < n; ++i ) {
            if ( disc[i] == -1 ) {
                dfs( i, i, disc, low, adj, cv );
            }
        }

        return cv;
    }

    private void dfs(int u, int parent, int[] disc, int[] low, List<List<Integer>> adj, List<List<Integer>> cv) {
        low[u] = disc[u] = ++time;
        for ( Integer v : adj.get(u) ) {
            // We ignore the parent
            if ( v == parent )
                continue;
            // trigger DFS for this child as it is unvisited
            if ( disc[v] == -1 ) {
                dfs(v, u, disc, low, adj, cv);

                // Check if our low can be set using visited child's low
                low[u] = Math.min(low[u], low[v]);

                // ** Main condition for Tarjan's Algorithm **
                if ( low[v] > disc[u] )
                    cv.add(Arrays.asList(u, v));
            } else {
                // v is not parent & it is already visited
                // Check if we can lower our low[u] with discovery time of v
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
