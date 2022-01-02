/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Arrays.asList(0);
        if (n == 2)
            return Arrays.asList(0, 1);

        int[] deg = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e: edges) {
            map.putIfAbsent(e[0], new ArrayList<>());
            map.putIfAbsent(e[1], new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
            deg[e[0]]++;
            deg[e[1]]++;
        }

        Set<Integer> vis = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (deg[i] == 1)
                q.add(i);
        }

        while (q.size() >= 2 && vis.size() < n) {
            for (int i = q.size(); i > 0; --i) {
                int u = q.poll();
                vis.add(u);
                for (int v: map.get(u)) {
                    if (!vis.contains(v) && --deg[v] == 1) {
                        q.add(v);
                        vis.add(v);
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty())
            ans.add(q.poll());

        return ans;
    }
}
