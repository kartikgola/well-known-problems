/*
 * Author: Kartik Gola
 * Date: 7/26/20 6:21 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package ds;

import java.util.Arrays;

public class UnionFind {

    private int unions;
    private int n;
    private int[] parent;

    public UnionFind(int n) {
        this.n = unions = n;
        parent = new int[n];
        Arrays.fill(parent, -1);
    }

    public int getUnionsCount() {
        return this.unions;
    }

    public int find(int u) {
        if ( parent[u] < 0 )
            return u;
        return parent[u] = find(parent[u]);
    }

    public void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if ( pu != pv ) {
            // Weight of pu is more
            if ( parent[pu] <= parent[pv] ) {
                parent[pv] = pu;
            } else {
                parent[pu] = pv;
            }
            unions--;
        }
    }
}