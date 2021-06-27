/*
 * Author: Kartik Gola
 * Date: 4/2/21, 10:55 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package util.ds.graph;

import util.ds.graph.edge.DirectedEdge;
import util.ds.graph.edge.Edge;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DirectedGraph<T extends Number> extends AbstractGraph<T> {

    public DirectedGraph(int size) {
        super(size);
    }

    @Override
    public void setEdges(List<Edge<T>> edges) {
        for (Edge<T> edge: edges)
            addEdge(edge);
    }

    @Override
    public void addEdge(Edge<T> edge) {
        adjMap.putIfAbsent(edge.from, new HashMap<>());
        adjMap.putIfAbsent(edge.to, new HashMap<>());
        adjMap.get(edge.from).put(edge.to, new DirectedEdge<>(edge));
    }

    @Override
    public List<Edge<T>> getDistinctEdges() {
        return adjMap.values()
                .stream()
                .map(Map::values)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<Edge<T>> getEdges() {
        return adjMap.values()
                .stream()
                .map(Map::values)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public T getAnyAdjacentVertex(T u) {
        return adjMap.get(u).keySet().iterator().next();
    }
}
