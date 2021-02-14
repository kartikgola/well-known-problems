/*
 * Author: Kartik Gola
 * Date: 8/6/20 6:53 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/is-graph-bipartite/
 */

package leetcode;

public class IsGraphBipartite {

    enum Color {
        RED,
        BLACK
    }

    private boolean dfs(int u, int[][] graph, Color[] colors, Color color) {
        if (colors[u] != null)
            return colors[u] == color;
        colors[u] = color;
        for (int v: graph[u])
            if (!dfs(v, graph, colors, color == Color.RED ? Color.BLACK : Color.RED))
                return false;
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        Color[] colors = new Color[graph.length];
        for (int u = 0; u < graph.length; ++u)
            if (colors[u] == null && !dfs(u, graph, colors, Color.RED))
                return false;
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
