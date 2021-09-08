/*
 * Author: Kartik Gola
 * Date: 9/8/21, 6:21 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
}
