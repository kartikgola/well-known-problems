/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:33 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package tree;

import graph.UndirectedGraph;
import graph.edge.UndirectedEdge;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PrimTest {

    @Test
    void testMSTGeneration() {
        final int size = 6;
        UndirectedGraph<Integer> graph = new UndirectedGraph<>(size);
        for (int node = 1; node <= size; node++)
            graph.addNode(node);
        graph.setEdges(Arrays.asList(
                new UndirectedEdge<>(1,2,3),
                new UndirectedEdge<>(1,5,5),
                new UndirectedEdge<>(2,5,6),
                new UndirectedEdge<>(2,3,5),
                new UndirectedEdge<>(3,6,3),
                new UndirectedEdge<>(3,4,9),
                new UndirectedEdge<>(5,6,2),
                new UndirectedEdge<>(6,4,7)
        ));
        UndirectedGraph<Integer> mst = new Prim<Integer>().prim(graph);
        assertEquals(20, mst.getDistinctEdges().stream().mapToInt(e -> e.weight).sum());
    }
}