/*
 * Author: Kartik Gola
 * Date: 4/2/21, 9:33 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
 */

package algorithms.graph;

import util.ds.graph.edge.Edge;
import util.ds.graph.Graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FloydWarshall<T extends Number> {

    /**
     * Implements Floyd-Warshall's all-source shortest-path algorithm
     * This is an exhaustive dynamic programming algorithm that tries to relax all possible pairs of vertices
     * Time Complexity = O(V^2 + V^3) = O(V^3)
     * @param graph : input graph
     * @return Map<T, Map<T, Integer>> where each key-value represents the shortest weighed-path between a vertex 'u' and 'v'
     */
    public Map<T, Map<T, Integer>> floydWarshall(Graph<T> graph) {
        Map<T, Map<T, Integer>> dist = new HashMap<>();
        List<T> vertices = graph.getVertices();
        for (T u: vertices) {
            dist.putIfAbsent(u, new HashMap<>());
            dist.get(u).putAll(graph.getVertices()
                    .stream()
                    .collect(Collectors.toMap(Function.identity(), v -> Integer.MAX_VALUE))
            );
            dist.get(u).put(u, 0);
            for (Edge<T> e: graph.getEdgesFrom(u)) {
                dist.get(u).put(e.to, e.weight);
            }
        }

        for (T k: vertices) {
            for (T i: vertices) {
                for (T j: vertices) {
                    if (dist.get(i).get(k) != Integer.MAX_VALUE && dist.get(k).get(j) != Integer.MAX_VALUE) {
                        dist.get(i).put(j, Math.min(
                                dist.get(i).get(j),
                                dist.get(i).get(k) + dist.get(k).get(j)
                        ));
                    }
                }
            }
        }

        return dist;
    }
}
