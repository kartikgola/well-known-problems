/*
 * Author: Kartik Gola
 * Date: 4/2/21, 10:55 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package util.ds.graph;

import util.ds.graph.edge.Edge;
import util.ds.graph.edge.UndirectedEdge;

import java.util.*;
import java.util.stream.Collectors;

public class UndirectedGraph<T extends Number> extends AbstractGraph<T> {

    public UndirectedGraph(int size) {
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
        adjMap.get(edge.from).put(edge.to, new UndirectedEdge<>(edge.from, edge.to, edge.weight));
        adjMap.putIfAbsent(edge.to, new HashMap<>());
        adjMap.get(edge.to).put(edge.from, new UndirectedEdge<>(edge.to, edge.from, edge.weight));
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
