/*
 * Author: Kartik Gola
 * Date: 4/2/21, 10:55 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package ds.graph;

import java.util.Arrays;
import java.util.HashMap;

public class UndirectedGraph extends AbstractGraph {

    public UndirectedGraph(int size) {
        super(size);
    }

    public void setEdges(int[][] edges) {
        for (int[] e: edges) {
            adj.putIfAbsent(e[0], new HashMap<>());
            adj.putIfAbsent(e[1], new HashMap<>());
            adj.get(e[0]).put(e[1], e[2]);
            adj.get(e[1]).put(e[0], e[2]);
            this.edges.add(Arrays.asList(e[0], e[1], e[2]));
        }
    }
}
