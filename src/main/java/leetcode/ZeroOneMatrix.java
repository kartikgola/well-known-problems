/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    int m;
    int n;
    int[][] mat;
    final int INF = 1000_000;

    private void updateDistance(int i, int j, int dist) {
        if ( i < 0 || i >= m || j < 0 || j >= n || mat[i][j] < dist )
            return;

        mat[i][j] = dist;
        int[][] pos = new int[][]{{i - 1, j}, {i, j + 1}, {i + 1, j}, {i, j - 1}};

        for ( int[] po : pos ) {
            updateDistance(po[0], po[1], dist + 1);
        }
    }

    private boolean hasZeroNeighbour(int i, int j) {
        int[][] pos = new int[][]{{i - 1, j}, {i, j + 1}, {i + 1, j}, {i, j - 1}};
        for ( int[] p : pos ) {
            if ( p[0] >= 0 && p[0] < m && p[1] >= 0 && p[1] < n && mat[p[0]][p[1]] == 0 ) {
                return true;
            }
        }
        return false;
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    public int[][] updateMatrixDFS(int[][] matrix) {
        m = matrix.length;
        if ( m  == 0 ) return new int[][]{};
        n = matrix[0].length;
        if ( n == 0 ) return new int[][]{};
        this.mat = matrix;

        for ( int i = 0; i < m; ++i )
            for ( int j = 0; j < n; ++j ) {
                if (mat[i][j] == 1 && !hasZeroNeighbour(i, j)) {
                    mat[i][j] = INF;
                }
            }

        for ( int i = 0; i < m; ++i ) {
            for ( int j = 0; j < n; ++j ) {
                if ( mat[i][j] == 1 ) {
                   updateDistance(i, j, 1);
                }
            }
        }

        return mat;
    }

    public int[][] updateMatrixBFS(int[][] matrix) {
        m = matrix.length;
        if ( m  == 0 ) return new int[][]{};
        n = matrix[0].length;
        if ( n == 0 ) return new int[][]{};

        int[][] dist = new int[m][n];
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        for ( int i = 0; i < m; ++i ) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    q.add(new Pair<>(i, j));
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        while ( !q.isEmpty() ) {
            Pair<Integer, Integer> pa = q.poll();
            int i = pa.getKey(), j = pa.getValue();
            int[][] pos = new int[][]{{i - 1, j}, {i, j + 1}, {i + 1, j}, {i, j - 1}};

            for ( int[] p : pos ) {
                if ( isValid(p[0], p[1]) && dist[p[0]][p[1]] != 0 && dist[p[0]][p[1]] > dist[i][j] + 1 ) {
                    dist[p[0]][p[1]] = dist[i][j] + 1;
                    q.add(new Pair<>(p[0], p[1]));
                }
            }
        }

        return dist;
    }

    public int[][] updateMatrixDP(int[][] matrix) {
        return new int[][]{};
    }
}
