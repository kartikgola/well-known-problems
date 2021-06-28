/*
 * Author: Kartik Gola
 * Date: 04/02/2021, 23:30
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package leetcode;

public class FindCityWithSmallestNumberOfNeighbors {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        final int INF = 1000_000_000;

        // Construct adjacency matrix
        int[][] adj = new int[n][n];
        for (int[] edge: edges) {
            adj[edge[0]][edge[1]] = edge[2];
            adj[edge[1]][edge[0]] = edge[2];
        }

        // Construct distance matrix
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = adj[i][j] == 0 ? INF : adj[i][j];
            }
        }

        // Apply floyd-warshall algorithm
        int maxCityIndex = -1,
                minCitiesReachable = 101;
        for (int k = 0; k < n; ++k) { // intermediate
            for (int i = 0; i < n; ++i) { // source
                for (int j = 0; j < n; ++j) { // destination
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // Find the cities reachable by each city
        for (int i = 0; i < n; ++i) {
            int citiesReachable = 0;
            for (int j = 0; j < n; ++j) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    citiesReachable++;
                }
            }
            if (citiesReachable < minCitiesReachable) {
                maxCityIndex = i;
                minCitiesReachable = citiesReachable;
            } else if (citiesReachable == minCitiesReachable && i > maxCityIndex) {
                maxCityIndex = i;
            }
        }

        return maxCityIndex;
    }
}
