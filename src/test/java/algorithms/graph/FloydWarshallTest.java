package algorithms.graph;

import ds.graph.Graph;
import ds.graph.edge.UndirectedEdge;
import ds.graph.UndirectedGraph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FloydWarshallTest {

    @Test
    void testShortestPathFinding() {
        Graph<Integer> graph = new UndirectedGraph<>(5);
        graph.setEdges(Arrays.asList(
                new UndirectedEdge<>(3,4,7),
                new UndirectedEdge<>(3,2,2),
                new UndirectedEdge<>(2,1,5),
                new UndirectedEdge<>(4,1,9),
                new UndirectedEdge<>(4,5,2),
                new UndirectedEdge<>(1,5,1)
        ));
        Map<Integer, Map<Integer, Integer>> dist = new FloydWarshall<Integer>().floydWarshall(graph);
        assertEquals(
                new HashMap<Integer, Map<Integer, Integer>>(){{
                    put(1, new HashMap<>(){{
                        put(1, 0); put(2, 5); put(3, 7); put(4, 3); put(5, 1);
                    }});
                    put(2, new HashMap<>(){{
                        put(1, 5); put(2, 0); put(3, 2); put(4, 8); put(5, 6);
                    }});
                    put(3, new HashMap<>(){{
                        put(1, 7); put(2, 2); put(3, 0); put(4, 7); put(5, 8);
                    }});
                    put(4, new HashMap<>(){{
                        put(1, 3); put(2, 8); put(3, 7); put(4, 0); put(5, 2);
                    }});
                    put(5, new HashMap<>(){{
                        put(1, 1); put(2, 6); put(3, 8); put(4, 2); put(5, 0);
                    }});
                }},
                dist
        );
    }
}