/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:33 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package graph;

import graph.edge.UndirectedEdge;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    @Test
    void testShortestPathFinding() {
        final int size = 5;
        Graph<Integer> graph1 = new UndirectedGraph<>(size);
        for (int node = 1; node <= size; node++)
            graph1.addNode(node);
        graph1.setEdges(Arrays.asList(
                new UndirectedEdge<>(1,2,5),
                new UndirectedEdge<>(1,3,3),
                new UndirectedEdge<>(1,4,7),
                new UndirectedEdge<>(3,4,1),
                new UndirectedEdge<>(2,4,3),
                new UndirectedEdge<>(2,5,2),
                new UndirectedEdge<>(4,5,2)
        ));
        assertEquals(
                new HashMap<Integer, Integer>(){{
                    put(1, 0); put(2, 5); put(3, 3); put(4, 4); put(5, 6);
                }},
                new Dijkstra<Integer>().dijkstra(graph1, 1)
        );
    }
}