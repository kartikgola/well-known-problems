/*
 * Author: Kartik Gola
 * Date: 8/6/20 6:53 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL:
 */

package leetcode;

public class IsGraphBipartite {

    private boolean dfs(int u, Boolean[] color, int[][] graph, boolean prevColor) {
        color[u] = !prevColor;
        for ( int v : graph[u] ) {
            if ( color[v] == color[u] )
                return false;
            else if ( color[v] == null && !dfs(v, color, graph, color[u]) )
                return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        final int n = graph.length;
        Boolean[] color = new Boolean[n];
        for ( int i = 0; i < n; ++i ) {
            if ( color[i] == null ) {
                if ( !dfs(i, color, graph, false) )
                    return false;
            }
        }

        return true;
    }

    // BFS Solution
//    public boolean isBipartite(int[][] graph) {
//        final int n = graph.length;
//        Boolean[] color = new Boolean[n];
//        Queue<Integer> q = new LinkedList<>();
//
//        for ( int i = 0; i < n; ++i ) {
//            if ( color[i] == null ) {
//                q.add(i);
//                color[i] = true;
//                while ( !q.isEmpty() ) {
//                    int u = q.poll();
//                    for ( int v : graph[u] ) {
//                        if ( color[v] == null ) {
//                            q.add(v);
//                            color[v] = !color[u];
//                        } else if ( color[v] == color[u] ) {
//                            return false;
//                        }
//                    }
//                }
//            }
//        }
//
//        return true;
//    }
}
