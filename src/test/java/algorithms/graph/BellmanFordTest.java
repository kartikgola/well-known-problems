/*
 * Author: Kartik Gola
 * Date: 5/26/21, 6:38 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package algorithms.graph;

import ds.graph.Graph;
import ds.graph.UndirectedGraph;
import javafx.util.Pair;
import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class BellmanFordTest extends TestCase {

    public void testBellmanFord() {
        Graph graph = new UndirectedGraph(5);
        // For graph, refer - https://media.geeksforgeeks.org/wp-content/uploads/bellmanford1.png
        graph.setEdges(new int[][]{
                {0,1,-1}, {0,2,4},
                {1,2,3}, {1,3,2}, {1,4,2},
                {3,2,5},
                {3,1,1}, {4,3,-3}
        });
        Pair<int[], int[]> p = new BellmanFord().bellmanFord(graph, 0);
        assertArrayEquals(new int[]{0, -1, 2, -2, 1}, p.getKey());
        assertArrayEquals(new int[]{-1, 0, 1, 4, 1}, p.getValue());
    }
}