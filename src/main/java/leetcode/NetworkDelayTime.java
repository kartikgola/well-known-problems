/*
 * Author: Kartik Gola
 * Date: 11/07/20, 1:36 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime {

    private int[][] initAdj(int N, int[][] times) {
        int[][] adj = new int[N + 1][N + 1];
        for ( int i = 1; i <= N; ++i )
            for ( int j = 1; j <= N; ++j )
                adj[i][j] = -1;

        for ( int[] time : times ) {
            if ( adj[time[0]][time[1]] == -1 )
                adj[time[0]][time[1]] = time[2];
            else
                adj[time[0]][time[1]] = Math.min(time[2], adj[time[0]][time[1]]);
        }
        return adj;
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        // Distance values of all nodes
        int[] dist = new int[N + 1];
        // Visited values of nodes
        boolean[] vis = new boolean[N + 1];

        // Priority Queue to get only low distance nodes
        Queue<Integer> pq = new PriorityQueue<>((Integer a, Integer b) -> Integer.compare(dist[a], dist[b]));
        for ( int i = 1; i <= N; ++i )
            dist[i] = i == K ? 0 : Integer.MAX_VALUE;

        // Adjacency matrix
        int[][] adj = initAdj(N, times);

        // Add source vertex K to the PQ
        pq.offer(K);

        while ( !pq.isEmpty() ) {
            int u = pq.poll();
            vis[u] = true;
            for ( int v = 1; v <= N; ++v ) {
                // Only process unvisited neighbors
                if ( !vis[v] && adj[u][v] > -1 ) {
                    int newDist = dist[u] + adj[u][v];
                    // Relax the distance if it is less
                    if ( newDist <= dist[v] ) {
                        dist[v] = newDist;
                        pq.offer(v);
                    }
                }
            }
        }

        // Maximum value of time to reach a node
        int time = Integer.MIN_VALUE;
        for ( int i = 1; i <= N; ++i ) {
            if ( dist[i] == Integer.MAX_VALUE )
                return -1;
            time = Math.max(time, dist[i]);
        }

        return time == Integer.MIN_VALUE ? -1 : time;
    }
}
