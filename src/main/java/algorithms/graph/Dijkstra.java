/*
 * Author: Kartik Gola
 * Date: 4/2/21, 9:33 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
 */

package algorithms.graph;

import ds.graph.Graph;
import javafx.util.Pair;

import java.util.*;

public class Dijkstra {

    /**
     * Implements Dijkstra's single-source shortest-path algorithm
     * Time Complexity = O(Elog(V))
     * @param graph
     * @param source
     * @return Pair<int[], int[]> where key and value represent distances and previous vertices respectively
     */
    public Pair<int[], int[]> dijkstra(Graph graph, int source) {
        int[] dist = new int[graph.getSize()];
        int[] prev = new int[graph.getSize()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[source] = 0;

        Set<Integer> visited = new HashSet<>();
        // Values in PQ are stored as {distance_from_source, vertex} pairs
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        pq.add(new Pair<>(0, source));

        while (!pq.isEmpty()) {
            int d = pq.peek().getKey(), // distance of current vertex 'u' from source
                from = pq.poll().getValue(); // current vertext 'u'
            if (visited.contains(from))
                continue;
            visited.add(from);
            for (Map.Entry<Integer, Integer> e: graph.getNeighborsOf(from).entrySet()) {
                int to = e.getKey(), // neighbor 'v' of 'u'
                    weight = e.getValue(); // weight of edge 'uv'
                // Relax the distance, dist[v]
                if (d + weight < dist[to]) {
                    dist[to] = dist[from] + weight;
                    prev[to] = from;
                    pq.add(new Pair<>(dist[to], to));
                }
            }
        }

        return new Pair<>(dist, prev);
    }
}
