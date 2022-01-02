/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:46 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package tree;

import graph.edge.Edge;
import graph.UndirectedGraph;

import java.util.*;

public class Prim<T extends Number> {

    /**
     * Implements Prim's Minimum Spanning Tree algorithm using Priority-Queue data structure
     * The algorithm first adds an arbitrary node to the tree. After this, the algorithm
     * always chooses a minimum-weight edge that adds a new node to the tree.
     * Time Complexity = O(Elog(E) + Elog(E)) = O(Elog(E))
     * @param graph : input graph
     * @return graph : representing a Minimum Spanning Tree (MST)
     */
    public UndirectedGraph<T> prim(UndirectedGraph<T> graph) {
        UndirectedGraph<T> mst = new UndirectedGraph<>(graph.getSize());
        Queue<Edge<T>> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        // Initialize with a random vertex
        T initialSource = graph.getVertices().get(new Random().nextInt(graph.getSize()));
        pq.addAll(graph.getEdgesFrom(initialSource));
        Set<T> visited = new HashSet<>();
        visited.add(initialSource);

        while (!pq.isEmpty()) {
            Edge<T> edge = pq.poll();
            if (visited.contains(edge.to))
                continue;
            visited.add(edge.to);
            // Add the edge to MST
            mst.addEdge(edge);
            // Add all the edges connected to the newly introduced vertex
            pq.addAll(graph.getEdgesFrom(edge.to));
        }

        return mst;
    }
}
