/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class AllPathsFromSourceToTarget {

    List<List<Integer>> ans = new ArrayList<>();

    private void dfs(int u, int x, int[][] graph, Stack<Integer> path) {
        path.add(u);
        if (u == x)
            ans.add(new ArrayList<>(path));
        // since graph is DAG, no need to check for loops leading to nodes already in path
        for (int v: graph[u])
            dfs(v, x, graph, path);
        path.pop();
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(0, graph.length-1, graph, new Stack<>());
        return ans;
    }

    public List<List<Integer>> allPathsSourceTargetBFS(int[][] graph) {
        final int n = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(new ArrayList<>(Arrays.asList(0)));

        while (!q.isEmpty()) {
            List<Integer> c = q.poll();
            if (c.get(c.size()-1) == n-1) {
                ans.add(c);
                continue;
            }
            for (int d: graph[c.get(c.size()-1)]) {
                List<Integer> t = new ArrayList<>(c);
                t.add(d);
                q.add(t);
            }
        }

        return ans;
    }
}
