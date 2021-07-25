package algorithms.tree;

import util.ds.graph.Graph;
import util.ds.graph.edge.UndirectedEdge;
import util.ds.graph.UndirectedGraph;
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