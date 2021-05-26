/*
 * Author: Kartik Gola
 * Date: 4/2/21, 9:33 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
 */

package algorithms.graph;

import ds.graph.Graph;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.List;

public class BellmanFord {

    /**
     * Implements Bellman-Ford's single-source shortest-path algorithm
     * Time Complexity = O(VE)
     * @param graph
     * @param source
     * @return Pair<int[], int[]> where key and value represent distances and previous vertices respectively
     */
    public Pair<int[], int[]> bellmanFord(Graph graph, int source) {
        int[] dist = new int[graph.getSize()];
        int[] prev = new int[graph.getSize()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[source] = 0;

        // Try to relax the distances 'V-1' times
        for (int i = 0; i < graph.getSize()-1; i++) {
            for (List<Integer> edge: graph.getEdges()) {
                int from = edge.get(0),
                    to = edge.get(1),
                    weight = edge.get(2);
                if (dist[from] != Integer.MAX_VALUE && dist[from] + weight < dist[to]) {
                    dist[to] = dist[from] + weight;
                    prev[to] = from;
                }
            }
        }

        // Try to relax the distances one more time
        // If any distance gets relaxed this time, the graph contains a -ve weight cycle
        for (List<Integer> edge: graph.getEdges()) {
            int from = edge.get(0),
                to = edge.get(1),
                weight = edge.get(2);
            if (dist[from] != Integer.MAX_VALUE && dist[from] + weight < dist[to]) {
                throw new IllegalArgumentException("Graph contains -ve weight cycle.");
            }
        }

        return new Pair<>(dist, prev);
    }

}
