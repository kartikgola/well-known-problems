package algorithms.graph;

import ds.graph.edge.DirectedEdge;
import ds.graph.SuccessorGraph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindSuccessorTest {

    @Test
    void successorOf() {
        SuccessorGraph<Integer> graph = new SuccessorGraph<>(4);
        graph.addEdge(new DirectedEdge<>(9, 3, 1));
        graph.addEdge(new DirectedEdge<>(1, 3, 1));
        graph.addEdge(new DirectedEdge<>(7, 1, 1));
        graph.addEdge(new DirectedEdge<>(3, 7, 1));
        FindSuccessor<Integer> findSuccessor = new FindSuccessor<>(graph);

        // TC for 1 step
        assertEquals(3, findSuccessor.successorOf(1, 1));
        assertEquals(7, findSuccessor.successorOf(3, 1));
        assertEquals(1, findSuccessor.successorOf(7, 1));
        assertEquals(3, findSuccessor.successorOf(9, 1));

        // TC for 11 steps
        assertEquals(7, findSuccessor.successorOf(1, 11));
        assertEquals(1, findSuccessor.successorOf(3, 11));
        assertEquals(3, findSuccessor.successorOf(7, 11));
        assertEquals(7, findSuccessor.successorOf(9, 11));
    }
}