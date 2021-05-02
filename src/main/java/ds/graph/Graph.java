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

    int getSize();

    Map<Integer, Map<Integer, Integer>> getAdj();

    /**
     * Get the list of vertices
     * @return: List<Integer> representing list of vertices
     */
    List<Integer> getVertices();

    /**
     * Sets the adjacency list using a 2D array of edges
     * @param edges: 2D array of Nx3 where every sub-array is a tuple of (from, to, edgeWeight)
     */
    void setEdges(int[][] edges);

    void setAdjacencyMatrix(int[][] matrix);
}
