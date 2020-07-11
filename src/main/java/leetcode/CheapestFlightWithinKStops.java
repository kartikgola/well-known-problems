/*
 * Author: Kartik Gola
 * Date: 11/07/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import java.util.*;

public class CheapestFlightWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] stops = new int[n];
        int[] costs = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        Arrays.fill(costs, Integer.MAX_VALUE);
        stops[src] = 0;
        costs[src] = 0;

        Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();
        for ( int[] flt : flights ) {
            Map<Integer, Integer> nbrs = adj.getOrDefault(flt[0], new HashMap<>());
            nbrs.put(flt[1], flt[2]);
            adj.put(flt[0], nbrs);
        }

        Queue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
            return a[1] - b[1];
        });
        pq.offer(new int[]{ src, 0, 0 });

        while ( !pq.isEmpty() ) {
            int[] val = pq.poll();
            int u = val[0],
                    currentCost = val[1],
                    currentStops = val[2];

            if ( u == dst ) return currentCost;
            if ( currentStops == K + 1 ) continue;

            if ( adj.containsKey(u) ) {
                for ( Map.Entry<Integer, Integer> e : adj.get(u).entrySet() ) {
                    int v = e.getKey(),
                            edgeCost = e.getValue();
                    if ( currentCost + edgeCost < costs[v] || currentStops < stops[v] ) {
                        pq.offer(new int[]{ v, currentCost + edgeCost, currentStops + 1 });
                        costs[v] = currentCost + edgeCost;
                        stops[v] = currentStops;
                    }
                }
            }
        }

        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }

}
