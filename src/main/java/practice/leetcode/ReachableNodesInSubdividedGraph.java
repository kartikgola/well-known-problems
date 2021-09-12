/*
 * Author: Kartik Gola
 * Date: 9/12/21, 5:07 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import util.GraphUtils;

import java.util.*;

public class ReachableNodesInSubdividedGraph {

    public int reachableNodes(int[][] edges, int k, int n) {
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] e: edges) {
            map.putIfAbsent(e[0], new HashMap<>());
            map.putIfAbsent(e[1], new HashMap<>());
            map.get(e[0]).put(e[1], e[2]+1);
            map.get(e[1]).put(e[0], e[2]+1);
        }

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v[0]));
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int d = pq.peek()[0],
                    u = pq.poll()[1];
            if (visited[u])
                continue;
            visited[u] = true;
            for (Map.Entry<Integer, Integer> e: map.getOrDefault(u, new HashMap<>()).entrySet()) {
                int v = e.getKey(),
                        w = e.getValue();
                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        int ans = 0;
        for (int d: dist)
            if (d <= k)
                ans++;

        for (int[] e: edges) {
            int ext = 0;
            int x = e[0];
            int y = e[1];
            int w = e[2];
            if (dist[x] <= k) {
                ext += Math.min(k - dist[x], e[2]);
            }
            if (dist[y] <= k) {
                ext += Math.min(k - dist[y], e[2]);
            }
            ext = Math.min(ext, e[2]);
            ans += ext;
        }

        return ans;
    }
}
