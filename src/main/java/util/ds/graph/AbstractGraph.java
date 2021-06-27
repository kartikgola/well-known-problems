/*
 * Author: Kartik Gola
 * Date: 4/4/21, 10:30 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package util.ds.graph;

import util.ds.graph.edge.Edge;

import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractGraph<T extends Number> implements Graph<T> {

    protected final int size;
    protected Map<T, Map<T, Edge<T>>> adjMap;

    public AbstractGraph(int size) {
        this.size = size;
        this.adjMap = new HashMap<>(size);
    }

    @Override
    public Map<T, Map<T, Edge<T>>> getAdjMap() {
        return adjMap;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public List<T> getVertices() {
        // Add all 'from' vertices
        final Set<T> verticesSet = new HashSet<>();
        verticesSet.addAll(adjMap.keySet());
        // Add all 'to' vertices
        verticesSet.addAll(adjMap.values()
            .stream()
            .map(Map::keySet)
            .flatMap(Collection::stream)
            .collect(Collectors.toSet())
        );
        return new ArrayList<>(verticesSet);
    }

    @Override
    public Map<T, Edge<T>> getAdjMapOf(T u) {
        return adjMap.getOrDefault(u, new HashMap<>());
    }

    @Override
    public List<Edge<T>> getEdgesFrom(T u) {
        return new ArrayList<>(adjMap.getOrDefault(u, new HashMap<>()).values());
    }

    @Override
    public String toString() {
        return "AbstractGraph{" +
                "size=" + size +
                ", adjMap=" + adjMap +
                '}';
    }
}
