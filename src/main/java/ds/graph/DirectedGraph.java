/*
 * Author: Kartik Gola
 * Date: 4/2/21, 10:55 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package ds.graph;

import java.util.HashMap;

public class DirectedGraph extends AbstractGraph {

    public DirectedGraph(int size) {
        super(size);
    }

    public void setEdges(int[][] edges) {
        for (int[] e: edges) {
            adj.putIfAbsent(e[0], new HashMap<>());
            adj.get(e[0]).put(e[1], e[2]);
        }
    }

    public void setAdjacencyMatrix(int[][] adjMat) {
        for (int i = 0; i < adjMat.length; ++i) {
            adj.putIfAbsent(i, new HashMap<>());
            for (int j = 0; j < adjMat[i].length; ++j) {
                adj.get(i).put(j, adjMat[i][j]);
            }
        }
    }
}
