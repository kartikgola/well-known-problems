/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class CheapestFlightWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // Known number of stops of a vertex
        int[] stops = new int[n];
        // Known cost of a vertex
        int[] costs = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        Arrays.fill(costs, Integer.MAX_VALUE);
        stops[src] = 0;
        costs[src] = 0;

        // Map of (from, (to, cost))
        Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();
        for ( int[] flt : flights ) {
            Map<Integer, Integer> nbrs = adj.getOrDefault(flt[0], new HashMap<>());
            nbrs.put(flt[1], flt[2]);
            adj.put(flt[0], nbrs);
        }

        // Tuple of (vertex, distance, stops)
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[1]));
        pq.offer(new int[]{ src, 0, 0 });

        while ( !pq.isEmpty() ) {
            int[] val = pq.poll();
            int u = val[0], // Value of node (or vertex)
                    currentCost = val[1], // Cost to reach till this point
                    currentStops = val[2]; // No. of airports in the path (including itself)

            // Base case - we found the destination
            if ( u == dst ) return currentCost;
            // No. of airports in path (inc. itself) == K + 1
            if ( currentStops == K + 1 ) continue;

            if ( adj.containsKey(u) ) {
                for ( Map.Entry<Integer, Integer> e : adj.get(u).entrySet() ) {
                    int v = e.getKey(),
                        edgeCost = e.getValue();
                    if ( currentCost + edgeCost < costs[v] || currentStops < stops[v] ) {
                        // Add the next possibility to PQ
                        // No. of stops for this next case will increase by 1
                        pq.offer(new int[]{ v, currentCost + edgeCost, currentStops + 1 });
                        costs[v] = currentCost + edgeCost;
                        stops[v] = currentStops;
                    }
                }
            }
        }

        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }

    public int findCheapestPriceBellmanFord(int n, int[][] flights, int src, int dst, int k) {
        if (src == dst)
            return 0;
        int[] prev = new int[n];
        int[] curr = new int[n];
        Arrays.fill(prev, Integer.MAX_VALUE);
        Arrays.fill(curr, Integer.MAX_VALUE);
        prev[src] = 0;
        // relax k+1 times, since no. of edges for k stops will be k+1
        for (int i = 0; i < k+1; i++) {
            curr[src] = 0;
            for (int[] flight : flights) {
                int previous_flight = flight[0];
                int current_flight = flight[1];
                int cost = flight[2];

                if (prev[previous_flight] < Integer.MAX_VALUE) {
                    curr[current_flight] = Math.min(curr[current_flight],
                            prev[previous_flight] + cost);
                }
            }
            prev = curr.clone();
        }
        return curr[dst] == Integer.MAX_VALUE ? -1 : curr[dst];
    }

}
