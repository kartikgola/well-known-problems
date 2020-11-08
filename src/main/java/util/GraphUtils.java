/*
 * Author: Kartik Gola
 * Date: 8/8/20 11:52 AM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL:
 */

package util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphUtils {

    public static int[] topologicalSort(int n, int[][] edges) {
        int[] ans = new int[n];
        int[] inDegrees = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        for ( int i = 0; i < n; ++i )
            adj.add(new ArrayList<>());

        for ( int[] edge : edges ) {
            inDegrees[edge[1]]++;
            adj.get(edge[0]).add(edge[1]);
        }

        for ( int i = 0; i < n; ++i ) {
            if ( inDegrees[i] == 0 ) {
                q.add(i);
                visited[i] = true;
            }
        }

        int w = 0;
        while ( !q.isEmpty() ) {
            int u = q.poll();
            ans[w++] = u;
            for ( Integer v : adj.get(u) ) {
                if ( !visited[v] && --inDegrees[v] == 0 ) {
                    q.add(v);
                    visited[v] = true;
                }
            }
        }

        if ( w == 0 )
            return new int[]{};
        return ans;
    }

    private static boolean hasBackEdge(int u, int parent, List<List<Integer>> adj, boolean[] vis) {
        if ( vis[u] )
            return true;
        vis[u] = true;
        for ( Integer v : adj.get(u) ) {
            if ( v != parent && hasBackEdge(v, u, adj, vis) )
                return true;
        }
        return false;
    }

    public static boolean isValidTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for ( int i = 0; i < n; ++i )
            adj.add(new ArrayList<>());

        for ( int[] edge : edges ) {
            int from = edge[0], to = edge[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        boolean[] vis = new boolean[n];

        // There should be no back-edge present in the graph
        if ( hasBackEdge(0, -1, adj, vis) )
            return false;

        // We should have no unvisited node left in the end
        // So, all nodes should be connected for graph to be a tree
        for ( boolean val : vis )
            if ( !val )
                return false;

        return true;
    }

    private static boolean hasCycle(int u, List<List<Integer>> adj, boolean[] visited, boolean[] path) {
        if ( !visited[u] ) {
            visited[u] = true;
            path[u] = true;

            for ( Integer v : adj.get(u) ) {
                if ( !visited[v] ) {
                    if ( hasCycle(v, adj, visited, path) )
                        return true;
                } else if ( path[v] ) {
                    return true;
                }
            }
        }
        path[u] = false;
        return false;
    }

    public static boolean hasCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for ( int i = 0; i < n; ++i )
            adj.add(new ArrayList<>());

        for ( int[] edge : edges )
            adj.get(edge[0]).add(edge[1]);

        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];

        for ( int u = 0; u < n; ++u ) {
            if ( !visited[u] && hasCycle(u, adj, visited, path) ) {
                return true;
            }
        }

        return false;
    }
}
