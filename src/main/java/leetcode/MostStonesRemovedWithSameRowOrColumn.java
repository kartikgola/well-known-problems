/*
 * Author: Kartik Gola
 * Date: 14/07/20, 10:50 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import java.util.Arrays;

public class MostStonesRemovedWithSameRowOrColumn {

    class UnionFind {

        int sets;
        int[] parent;

        UnionFind(int n) {
            sets = n;
            parent = new int[n];
            Arrays.fill(parent, -1);
        }

        int find(int u) {
            if ( parent[u] < 0 )
                return u;
            return parent[u] = find(parent[u]);
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if ( pu != pv ) {
                // Weight of pu is more
                if ( parent[pu] <= parent[pv] ) {
                    parent[pv] = pu;
                } else {
                    parent[pu] = pv;
                }
                sets--;
            }
        }
    }

    public int removeStones(int[][] stones) {
        final int n = stones.length;
        UnionFind unionFind = new UnionFind(n);
        for ( int i = 0; i < n; ++i ) {
            for ( int j = i + 1; j < n; ++j ) {
                if ( stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1] )
                    unionFind.union(i, j);
            }
        }
        return n - unionFind.sets;
    }
}
