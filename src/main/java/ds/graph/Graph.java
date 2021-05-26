/*
 * Author: Kartik Gola
 * Date: 4/4/21, 10:29 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package ds.graph;

import java.util.List;
import java.util.Map;

public interface Graph {

    /**
     * Get the size of graph (no. of vertices)
     * @return int
     */
    int getSize();

    /**
     * Get the adjacency map of the graph
     * @return Map<Integer, Map<Integer, Integer>>
     */
    Map<Integer, Map<Integer, Integer>> getAdjacencyMap();

    /**
     * Get the list of vertices
     * @return: List<Integer> representing list of vertices
     */
    List<Integer> getVerticesList();

    /**
     * Get List of all edges as tuples of (fromEdge, toEdge, edgeWeight)
     * @return List<List<Integer>>
     */
    List<List<Integer>> getEdges();

    /**
     * Get the neighbors of a specific vertex, 'u'
     * @param u
     * @return Map<Integer, Integer> where key is a neighbor and value is its weight
     */
    Map<Integer, Integer> getNeighborsOf(int u);

    /**
     * Sets the adjacency list using a 2D array of edges
     * @param edges: 2D array of size Nx3 where every sub-array is a tuple of (fromEdge, toEdge, edgeWeight)
     */
    void setEdges(int[][] edges);

    /**
     * Set the adjacency map of the graph using a 2D adjacency matrix
     * @param matrix: 2D matrix where values represent edge weights
     */
    void setAdjacencyMatrix(int[][] matrix);
}
