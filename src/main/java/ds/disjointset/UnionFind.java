/*
 * Author: Kartik Gola
 * Date: 7/26/20 6:21 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package ds.disjointset;

import java.util.Arrays;

public class UnionFind {

    private int groups;
    private final int[] parent;

    public UnionFind(int size) {
        groups = size;
        parent = new int[size];
        Arrays.fill(parent, -1);
    }

    /**
     * Get the total number of sets/groups present in this disjoint set
     * @return int
     */
    public int getTotalGroups() {
        return this.groups;
    }

    /**
     * Finds the parent of a vertex 'u'
     * @param u : int vertex 'u'
     * @return int
     */
    public int find(int u) {
        if ( parent[u] < 0 )
            return u;
        return parent[u] = find(parent[u]);
    }

    /**
     * Performs union of two vertices 'u' and 'v'
     * Union is performed by weight
     * @param u : first vertex
     * @param v : second vertex
     * @return true if parent of 'u' and 'v' is same; false, otherwise
     */
    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if ( pu != pv ) {
            // Weight of pu is more (more negative means higher weight)
            if ( parent[pu] <= parent[pv] ) {
                parent[pv] = pu;
                parent[pu]--;
            } else {
                parent[pu] = pv;
                parent[pv]--;
            }
            groups--;
            return true;
        }
        // In case parents of 'u' and 'v' are same, we return false
        return false;
    }
}