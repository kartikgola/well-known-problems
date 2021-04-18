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

    List<Integer> getVertices();

    void setEdges(int[][] edges);

    void setAdjacencyMatrix(int[][] matrix);
}
