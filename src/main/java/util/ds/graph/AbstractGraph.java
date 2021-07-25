/*
 * Author: Kartik Gola
 * Date: 4/4/21, 10:30 PM
 * Copyright (c) 2021 | https://kartikgola.com
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
        return new ArrayList<>(adjMap.keySet());
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
    public void addNode(T node) {
        adjMap.putIfAbsent(node, new HashMap<>());
    }

    @Override
    public String toString() {
        return "AbstractGraph{" +
                "size=" + size +
                ", adjMap=" + adjMap +
                '}';
    }
}
