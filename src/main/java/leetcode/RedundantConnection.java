/*
 * Author: Kartik Gola
 * Date: 6/25/21, 3:48 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/redundant-connection/
 */

package leetcode;

import util.ds.disjointset.UnionFind;

import java.util.*;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length, false);
        for (int[] e: edges) {
            if (!uf.union(e[0], e[1]))
                return e;
        }
        return new int[]{};
    }

    private boolean isCyclic(int u, int p, boolean[] path, Map<Integer, Set<Integer>> map) {
        path[u] = true;
        for (int v: map.getOrDefault(u, new HashSet<>())) {
            if (v != p)
                if (path[v] || isCyclic(v, u, path, map))
                    return true;
        }
        path[u] = false;
        return false;
    }

    public int[] findRedundantConnection2(int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        boolean[] path = new boolean[edges.length+1];
        for (int[] e: edges) {
            map.putIfAbsent(e[0], new HashSet<>());
            map.putIfAbsent(e[1], new HashSet<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
            Arrays.fill(path, false);
            path[e[0]] = true;
            if (isCyclic(e[0], e[1], path, map))
                return e;
        }
        return new int[]{};
    }
}
