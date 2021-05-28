package algorithms.graph;

import ds.graph.Graph;
import ds.graph.UndirectedEdge;
import ds.graph.UndirectedGraph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    @Test
    void testShortestPathFinding() {
        Graph<Integer> graph1 = new UndirectedGraph<>(5);
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
                new BellmanFord<Integer>().bellmanFord(graph1, 1)
        );
    }
}