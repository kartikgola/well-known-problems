/*
 * Author: Kartik Gola
 * Date: 4/2/21, 9:33 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://en.wikipedia.org/wiki/Bellman%E2%80%93Ford_algorithm
 */

package algorithms.graph;

import ds.graph.edge.Edge;
import ds.graph.Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BellmanFord<T> {

    /**
     * Implements Bellman-Ford's single-source shortest-path algorithm
     * Time Complexity = O(VE)
     * @param graph : input graph
     * @param source : starting vertex
     * @return Map<T, Integer> representing (vertex, shortestDistanceFromSource)
     */
    public Map<T, Integer> bellmanFord(Graph<T> graph, T source) {
        Map<T, Integer> dist = new HashMap<>(graph.getVertices().stream().collect(Collectors.toMap(Function.identity(), v -> Integer.MAX_VALUE)));
        dist.put(source, 0);

        // 1. Try to relax the distances 'V-1' times
        for (int i = 0; i < graph.getSize()-1; i++) {
            for (Edge<T> e: graph.getEdges()) {
                if (dist.get(e.from) != Integer.MAX_VALUE && dist.get(e.to) > e.weight + dist.get(e.from)) {
                    dist.put(e.to, e.weight + dist.get(e.from));
                }
            }
        }

        // 2. Try to relax the distances one more time
        // If any distance gets relaxed this time, the graph contains a -ve weight cycle
        for (Edge<T> e: graph.getEdges()) {
            if (dist.get(e.from) != Integer.MAX_VALUE && dist.get(e.to) > e.weight + dist.get(e.from)) {
                throw new IllegalArgumentException("Graph contains -ve weight cycle.");
            }
        }

        return dist;
    }

}
