/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import disjointset.UnionFind;

import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectedComponentsInUndirectedGraph {

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        List<List<Integer>> adj = new ArrayList<>();
        for ( int i = 0; i < n; ++i )
            adj.add(new ArrayList<>());

        for ( int[] edge : edges ) {
            int from = edge[0],
                    to = edge[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        for ( int u = 0; u < adj.size(); ++u ) {
            for ( Integer v : adj.get(u) ) {
                uf.union(u, v);
            }
        }

        return uf.getTotalGroups();
    }
}
