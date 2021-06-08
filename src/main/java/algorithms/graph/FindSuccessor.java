package algorithms.graph;

import ds.graph.Graph;
import ds.graph.SuccessorGraph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSuccessor<T> {

    private final int STEPS_LIMIT = (int) Math.pow(2, 30);
    private final Map<T, Map<Integer, T>> dp = new HashMap<>();

    public FindSuccessor(SuccessorGraph<T> graph) {
        // Successor graphs are special Directed Acyclic graphs where out-degree of each vertex = 1
        //  {
        //  1: {1,v1}, {2, v2}, {4, v3}.....,
        //  2: {1, v4}, {2, v5}, {4, v6}....,
        //  }
        List<T> vertices = graph.getVertices();
        for (int step = 1; step < STEPS_LIMIT; step *= 2) {
            for (T v: vertices) {
                dp.putIfAbsent(v, new HashMap<>());
                if (step == 1) {
                    dp.get(v).put(step, graph.getAnyAdjacentVertex(v));
                } else {
                    dp.get(v).put(step, dp.get(dp.get(v).get(step/2)).get(step/2));
                }
            }
        }
    }

    T successorOf(T u, int steps) {
        int jump = STEPS_LIMIT / 2;
        T v = u;
        while (steps > 0) {
            while (jump > steps)
                jump /= 2;
            v = dp.get(v).get(jump);
            steps -= jump;
        }
        return v;
    }
}
