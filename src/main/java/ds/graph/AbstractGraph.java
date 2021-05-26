/*
 * Author: Kartik Gola
 * Date: 4/4/21, 10:30 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package ds.graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class AbstractGraph implements Graph {

    protected final int size;
    protected Map<Integer, Map<Integer, Integer>> adj;
    protected List<List<Integer>> edges;

    public AbstractGraph(int size) {
        this.size = size;
        this.adj = new HashMap<>(size);
        this.edges = new ArrayList<>(size);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public List<List<Integer>> getEdges() {
        return edges;
    }

    public Map<Integer, Map<Integer, Integer>> getAdjacencyMap() {
        return adj;
    }

    public Map<Integer, Integer> getNeighborsOf(int u) {
        return adj.getOrDefault(u, new HashMap<>());
    }

    public List<Integer> getVerticesList() {
        return IntStream.range(0, size).boxed().collect(Collectors.toList());
    }

    public void setAdjacencyMatrix(int[][] adjMat) {
        for (int i = 0; i < adjMat.length; ++i) {
            adj.putIfAbsent(i, new HashMap<>());
            for (int j = 0; j < adjMat[i].length; ++j) {
                adj.get(i).put(j, adjMat[i][j]);
                edges.add(Arrays.asList(i, j, adjMat[i][j]));
            }
        }
    }
}
