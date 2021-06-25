/*
 * Author: Kartik Gola
 * Date: 6/25/21, 3:48 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/redundant-connection/
 */

package leetcode;

import util.ds.disjointset.UnionFind;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length, false);
        for (int[] e: edges) {
            if (!uf.union(e[0], e[1]))
                return e;
        }
        return new int[]{};
    }
}
