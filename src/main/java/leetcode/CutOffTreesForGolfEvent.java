/*
 * Author: Kartik Gola
 * Date: 7/10/20 12:01 AM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class CutOffTreesForGolfEvent {

    private int minDist(int[] from, int[] to, List<List<Integer>> forest) {
        final int m = forest.size();
        final int n = forest.get(0).size();

        // Holds tuple of (source, destination, distance)
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{from[0], from[1], 0});
        boolean[][] vis = new boolean[m][n];
        vis[from[0]][from[1]] = true;

        int[][] pos = new int[][]{ {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        while ( !q.isEmpty() ) {
            int[] k = q.poll();
            if ( k[0] == to[0] && k[1] == to[1] )
                return k[2];

            for ( int[] p : pos ) {
                int x = k[0] + p[0], y = k[1] + p[1];
                if ( x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && forest.get(x).get(y) > 0 ) {
                    q.add(new int[]{x, y, k[2] + 1});
                    vis[x][y] = true;
                }
            }
        }
        return -1;
    }

    public int cutOffTree(List<List<Integer>> forest) {
        final int m = forest.size();
        final int n = forest.get(0).size();

        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> forest.get(a[0]).get(a[1])));

        for ( int i = 0; i < m; ++i ) {
            for ( int j = 0; j < n; ++j ) {
                if ( forest.get(i).get(j) > 1 )
                    q.add(new int[]{i, j});
            }
        }

        int d = 0;
        int[] from = new int[]{0, 0};
        while ( !q.isEmpty() ) {
            int[] to = q.poll();
            int md = minDist(from, to, forest);

            // If tree cannot be reached due to obstacles
            // we return -1
            if ( md == -1 ) return -1;

            // Clear the tree
            forest.get(to[0]).set(to[1], 1);

            // Increase distance & move to point c
            d += md;
            from = to;
        }

        return d;
    }
}
