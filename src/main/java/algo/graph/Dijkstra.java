/*
 * Author: Kartik Gola
 * Date: 4/2/21, 9:33 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
 */

package algo.graph;

import ds.graph.UndirectedGraph;
import javafx.util.Pair;

import java.util.*;

public class Dijkstra {

    public Pair<int[], int[]> dijkstra(UndirectedGraph graph, int source) {
        int[] dist = new int[graph.size];
        int[] prev = new int[graph.size];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[source] = 0;

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(v -> dist[v]));
        pq.addAll(graph.getVertices());

        while (!pq.isEmpty()) {
            int u = pq.poll();
            visited.add(u);
            if (dist[u] != Integer.MAX_VALUE) {
                for (Map.Entry<Integer, Integer> e: graph.adj.getOrDefault(u, new HashMap<>()).entrySet()) {
                    int v = e.getKey();
                    int weight = e.getValue();
                    if (weight > 0 && !visited.contains(v) && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        prev[v] = u;
                        pq.add(pq.remove());
                    }
                }
            }
        }

        return new Pair<>(dist, prev);
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(9);
        // For graph, refer - https://www.geeksforgeeks.org/wp-content/uploads/Fig-11.jpg
        graph.setAdjacencyMatrix(new int[][]{
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
        });
        Pair<int[], int[]> p = new Dijkstra().dijkstra(graph, 0);
        System.out.println(Arrays.toString(p.getKey()));
        System.out.println(Arrays.toString(p.getValue()));
    }
}
