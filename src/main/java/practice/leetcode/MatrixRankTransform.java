/*
 * Author: Kartik Gola
 * Date: 8/10/21, 3:22 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.*;

public class MatrixRankTransform {

    class UnionFind2D {

        // Maps row index to one of the members of the group
        Map<Integer, Integer> r = new HashMap<>();
        // Maps column index to one of the members of the group
        Map<Integer, Integer> c = new HashMap<>();
        // Maps parent position to child positions held
        Map<Integer, Set<Integer>> map = new HashMap<>();

        int[] pa;
        int m, n;

        public UnionFind2D(int m, int n) {
            this.m = m;
            this.n = n;
            pa = new int[m*n];
            Arrays.fill(pa, -1);
        }

        int find(int e) {
            if (pa[e] < 0)
                return e;
            return pa[e] = find(pa[e]);
        }

        void add(int x) {
            map.putIfAbsent(x, new HashSet<>());
            int i = x/n, j = x%n;
            if (r.containsKey(i) && c.containsKey(j)) {
                union(r.get(i), c.get(j));
                union(x, r.get(i));
            } else if (r.containsKey(i)) {
                union(x, r.get(i));
            } else if (c.containsKey(j)) {
                union(x, c.get(j));
            }
            r.put(i, x);
            c.put(j, x);
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                map.putIfAbsent(px, new HashSet<>());
                map.putIfAbsent(py, new HashSet<>());
                if (pa[px] <= pa[py]) {
                    pa[px] += pa[py];
                    pa[py] = px;
                    map.get(px).addAll(map.get(py));
                    map.get(px).add(py);
                    map.remove(py);
                } else {
                    pa[py] += pa[px];
                    pa[px] = py;
                    map.get(py).addAll(map.get(px));
                    map.get(py).add(px);
                    map.remove(px);
                }
            }
        }
    }

    public int[][] matrixRankTransform(int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        final int[][] ans = new int[m][n];
        int[][] temp = new int[m*n][2];
        int[] row = new int[m];
        int[] col = new int[n];
        UnionFind2D uf = new UnionFind2D(m, n);

        // Create new temp array having tuple of the form (value, position)
        // value = matrix[i][j], position = i * n + j
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i*n+j] = new int[]{matrix[i][j], i*n+j};
            }
        }

        Arrays.sort(temp, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < temp.length;) {
            int j = i;

            // Try to group all the cells which have same value
            while (j < temp.length && temp[j][0] == temp[i][0])
                uf.add(temp[j++][1]);

            for (Map.Entry<Integer, Set<Integer>> e: uf.map.entrySet()) {
                int x = e.getKey() / n, y = e.getKey() % n;
                int rank = Math.max(row[x], col[y]);
                // Check the max rank in rows and cols of the grouped cells
                for (int v: e.getValue())
                    rank = Math.max(rank, Math.max(row[v/n], col[v%n]));

                // Rank of mat[x][y] is maximum rank in all rows and cols of the grouped cells + 1
                ans[x][y] = rank + 1;
                row[x] = col[y] = ans[x][y];

                // Set the newly obtained rank as the maximum rank for every grouped cell's rows and cols
                for (int v: e.getValue()) {
                    int p = v/n, q = v%n;
                    row[p] = col[q] = ans[p][q] = ans[x][y];
                }
            }

            // Clear uf properties since they are set as per currently grouped cells
            uf.r.clear();
            uf.c.clear();
            uf.map.clear();
            i = j;
        }

        return ans;
    }

    public static void main(String[] args) {
        new MatrixRankTransform().matrixRankTransform(new int[][]{{7,7}, {7,7}});
    }
}
