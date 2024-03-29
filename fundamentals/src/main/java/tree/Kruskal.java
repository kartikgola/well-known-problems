/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:46 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package tree;

import disjointset.UnionFindGeneric;
import graph.edge.Edge;
import graph.edge.UndirectedEdge;
import graph.UndirectedGraph;

import java.util.Comparator;
import java.util.List;

public class Kruskal<T extends Number> {

    /**
     * Implements Kruskal's Minimum Spanning Tree algorithm using Union-Find data structure.
     * This is a greedy algorithm which picks edges in the order of their weights. The algorithm
     * goes through the edges ordered by their weights, and always adds an edge to the tree if
     * it does not create a cycle.
     * Time Complexity = O(Elog(E) + Elog(E)) = O(Elog(E))
     * @param graph : input graph
     * @return graph : representing a Minimum Spanning Tree (MST)
     */
    public UndirectedGraph<T> kruskal(UndirectedGraph<T> graph) {
        // 1. Sort the edges by weights
        List<Edge<T>> edges = graph.getDistinctEdges();
        boolean[] isMSTEdge = new boolean[edges.size()];
        edges.sort(Comparator.comparingInt(e -> e.weight));

        // 2. Create disjoint set data structure and perform union
        UnionFindGeneric<T> uf = new UnionFindGeneric<>(graph.getVertices());
        for (int i = 0; i < edges.size(); ++i) {
            Edge<T> edge = edges.get(i);
            isMSTEdge[i] = uf.union(edge.from, edge.to);
        }

        // 3. Get the data of included vertices
        // and create a new Graph
        UndirectedGraph<T> mst = new UndirectedGraph<>(graph.getSize());
        for (int i = 0; i < edges.size(); i++) {
            if (isMSTEdge[i])
                mst.addEdge(new UndirectedEdge<>(edges.get(i)));
        }

        return mst;
    }
}
