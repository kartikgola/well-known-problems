package algorithms.tree;

import ds.graph.Edge;
import ds.graph.Graph;
import ds.graph.UndirectedEdge;
import ds.graph.UndirectedGraph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class KruskalTest {

    @Test
    void testMSTGeneration() {
        Graph<Integer> graph = new UndirectedGraph<>(5);
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
        Graph<Integer> mst = new Kruskal<Integer>().kruskal(graph);
        assertEquals(
                new HashSet<Edge<Integer>>(){{
                    add(new UndirectedEdge<>(1, 2, 3));
                    add(new UndirectedEdge<>(1, 5, 5));
                    add(new UndirectedEdge<>(3, 6, 3));
                    add(new UndirectedEdge<>(4, 6, 7));
                    add(new UndirectedEdge<>(5, 6, 2));
                }},
                new HashSet<>(mst.getDistinctEdges())
        );
    }
}