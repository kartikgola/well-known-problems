package algorithms.tree;

import util.ds.graph.Graph;
import util.ds.graph.edge.UndirectedEdge;
import util.ds.graph.UndirectedGraph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        assertEquals(20, mst.getDistinctEdges().stream().mapToInt(e -> e.weight).sum());
    }
}