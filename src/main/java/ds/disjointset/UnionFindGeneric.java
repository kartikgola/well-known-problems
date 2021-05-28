/*
 * Author: Kartik Gola
 * Date: 7/26/20 6:21 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package ds.disjointset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnionFindGeneric<T> {

    private int groups;
    private final Map<T, T> parent;
    private final Map<T, Integer> weight;

    public UnionFindGeneric(List<T> sets) {
        groups = sets.size();
        parent = new HashMap<>();
        weight = new HashMap<>();
        for (T set: sets) {
            parent.put(set, null);
            weight.put(set, -1);
        }
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
    public T find(T u) {
        if (parent.get(u) == null)
            return u;
        parent.put(u, find(parent.get(u)));
        return parent.get(u);
    }

    /**
     * Performs union of two vertices 'u' and 'v'
     * Union is performed by weight
     * @param u : first vertex
     * @param v : second vertex
     * @return true if parent of 'u' and 'v' is same; false, otherwise
     */
    public boolean union(T u, T v) {
        T pu = find(u);
        T pv = find(v);
        if (pu != pv) {
            // Weight of pu is more (more negative means higher weight)
            if ( weight.get(pu) <= weight.get(pv) ) {
                parent.put(pv, pu);
                weight.put(pu, weight.get(pu) - 1);
            } else {
                parent.put(pu, pv);
                weight.put(pv, weight.get(pv) - 1);
            }
            groups--;
            return true;
        }
        // In case parents of 'u' and 'v' are same, we return false
        return false;
    }
}