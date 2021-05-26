/*
 * Author: Kartik Gola
 * Date: 5/26/21, 6:41 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package algorithms.graph;

import ds.graph.Graph;
import ds.graph.UndirectedGraph;
import javafx.util.Pair;
import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class DijkstraTest extends TestCase {

    public void testDijkstra() {
        Graph graph = new UndirectedGraph(9);
        // For graph, refer - https://www.geeksforgeeks.org/wp-content/uploads/Fig-11.jpg
        graph.setEdges(new int[][]{
                {0,1,4}, {0,7,8},
                {1,2,8}, {1,7,11},
                {2,8,2}, {2,3,7}, {2,5,4},
                {3,4,9}, {3,5,14},
                {4,5,10},
                {5,6,2},
                {6,8,6}, {6,7,1},
                {7,8,7}
        });
        Pair<int[], int[]> p = new Dijkstra().dijkstra(graph, 0);
        assertArrayEquals(new int[]{0, 4, 12, 19, 21, 11, 9, 8, 14}, p.getKey());
        assertArrayEquals(new int[]{-1, 0, 1, 2, 5, 6, 7, 0, 2}, p.getValue());
    }
}