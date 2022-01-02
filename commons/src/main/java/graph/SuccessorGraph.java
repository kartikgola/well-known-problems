/*
 * Author: Kartik Gola
 * Date: 6/8/21, 7:31 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package graph;

import graph.edge.DirectedEdge;
import graph.edge.Edge;

import java.util.HashMap;

public class SuccessorGraph<T extends Number> extends DirectedGraph<T> {

    public SuccessorGraph(int size) {
        super(size);
    }

    @Override
    public void addEdge(Edge<T> edge) {
        adjMap.putIfAbsent(edge.from, new HashMap<>());
        adjMap.putIfAbsent(edge.to, new HashMap<>());
        adjMap.get(edge.from).put(edge.to, new DirectedEdge<>(edge));
        if (adjMap.get(edge.from).size() > 1)
            throw new IllegalArgumentException("Out-degree of every vertex can only be 1");
    }
}
