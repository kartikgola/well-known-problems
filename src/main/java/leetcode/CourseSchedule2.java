/*
 * Author: Kartik Gola
 * Date: 26/06/20, 2:14 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import java.util.*;

public class CourseSchedule2 {

    // Visits a vertex
    // @returns true, if node is part of a cycle; false, otherwise
    private boolean visit(int v, boolean[] path, boolean[] visited, Stack<Integer> st, List<List<Integer>> req) {
        if ( !visited[v] ) {
            visited[v] = true;
            path[v] = true;

            for ( Integer nbr : req.get(v) ) {
                if ( !visited[nbr] ) {
                    if ( visit(nbr, path, visited, st, req) )
                        return true;
                } else if ( path[nbr] ) {
                    return true;
                }
            }
        }
        path[v] = false;
        st.push(v);
        return false;
    }

    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> req = new ArrayList<>(n);
        for ( int i = 0; i < n; ++i )
            req.add(new ArrayList<>());

        for ( int[] p : pre )
            req.get(p[0]).add(p[1]);

        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for ( int i = 0; i < n; ++i ) {
            if ( !visited[i] )
                if ( visit(i, path, visited, st, req) ) {
                    return new int[]{};
                }
        }

        int j = st.size() - 1;
        int[] res = new int[st.size()];
        while ( !st.empty() ) {
            res[j--] = st.pop();
        }

        return res;
    }

    public int[] findOrder2(int n, int[][] pre) {
        int[] res = new int[n];
        List<List<Integer>> req = new ArrayList<>(n);
        for ( int i = 0; i < n; ++i )
            req.add(new ArrayList<>());

        int[] indegree = new int[n];
        for ( int[] p : pre ) {
            req.get(p[0]).add(p[1]);
            indegree[p[1]]++;
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for ( int i = 0; i < n; ++i ) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int w = n - 1;
        while ( !q.isEmpty() ) {
            int u = q.poll();
            visited[u] = true;
            res[w--] = u;
            for ( Integer v : req.get(u) ) {
                indegree[v]--;
                if ( !visited[v] && indegree[v] == 0 ) {
                    q.add(v);
                    visited[v] = true;
                }
            }
        }

        if ( w != -1 )
            return new int[]{};
        return res;
    }

}
