/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:46 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package graph;

import graph.edge.Edge;
import util.Pair;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Dijkstra<T extends Number> {

    /**
     * Implements Dijkstra's single-source shortest-path algorithm
     * This is a greedy algorithm which always picks the vertex having minimum distance from source
     * Time Complexity = O(Elog(V))
     * @param graph : input graph
     * @param source : starting vertex
     * @return Map<T, Integer> representing (vertex, shortestDistanceFromSource)
     */
    public Map<T, Integer> dijkstra(Graph<T> graph, T source) {
        Map<T, Integer> dist = new HashMap<>(graph.getVertices().stream().collect(Collectors.toMap(Function.identity(), v -> Integer.MAX_VALUE)));
        dist.put(source, 0);

        Set<T> visited = new HashSet<>();
        // Values in PQ are stored as {distanceFromSource, vertex} pairs
        Queue<Pair<Integer, T>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        pq.add(new Pair<>(0, source));

        while (!pq.isEmpty()) {
            int d = pq.peek().getKey(); // distance of current vertex 'u' from source
            T from = pq.poll().getValue(); // current vertex 'u'
            if (visited.contains(from))
                continue;
            visited.add(from);
            for (Edge<T> e: graph.getEdgesFrom(from)) {
                // Relax the distance, dist[v]
                if (d + e.weight < dist.getOrDefault(e.to, Integer.MAX_VALUE)) {
                    dist.put(e.to, d + e.weight);
                    pq.add(new Pair<>(d + e.weight, e.to));
                }
            }
        }

        return dist;
    }
}
