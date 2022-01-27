/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class CourseSchedule2 {

    // DFS method that performs 2 things -
    // 1. Checks for cycle in the graph
    // 2. Populates Stack<Integer> while doing DFS
    private boolean checkCycle(int u, boolean[] path, boolean[] visited, Stack<Integer> st, List<List<Integer>> req) {
        if (!visited[u]) {
            visited[u] = true;
            path[u] = true;

            for (Integer nbr : req.get(u)) {
                if (!visited[nbr]) {
                    if (checkCycle(nbr, path, visited, st, req))
                        return true;
                } else if (path[nbr])
                    return true;
            }
        }
        path[u] = false;
        st.push(u);
        return false;
    }

    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> req = new ArrayList<>(n);
        for ( int i = 0; i < n; ++i )
            req.add(new ArrayList<>());

        // req[i] = j, means that 'j' is a pre-requisite for 'i'
        for (int[] p : pre)
            req.get(p[0]).add(p[1]);

        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for ( int i = 0; i < n; ++i ) {
            if (!visited[i])
                if (checkCycle(i, path, visited, st, req))
                    return new int[]{};
        }

        return st.stream().mapToInt(i -> i).toArray();
    }

    // Kahn's algorithm O(V+E)
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
