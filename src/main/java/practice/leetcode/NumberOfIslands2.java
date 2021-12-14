/*
 * Author: Kartik Gola
 * Date: 9/25/21, 10:08 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslands2 {

    private int[][][] root;

    private int[] find(int i, int j) {
        if (root[i][j][0] < 0 && root[i][j][1] < 0)
            return new int[]{i, j};
        return root[i][j] = find(root[i][j][0], root[i][j][1]);
    }

    private boolean union(int i, int j, int k, int l) {
        int[] a = find(i, j);
        int[] b = find(k, l);
        if (!Arrays.equals(a, b)) {
            int va = root[a[0]][a[1]][0];
            int vb = root[b[0]][b[1]][0];
            if (va <= vb) {
                root[a[0]][a[1]][0] = va+vb;
                root[b[0]][b[1]][0] = a[0];
                root[b[0]][b[1]][1] = a[1];
            } else {
                root[b[0]][b[1]][0] = va+vb;
                root[a[0]][a[1]][0] = b[0];
                root[a[0]][a[1]][1] = b[1];
            }
            return true;
        }
        return false;
    }

    public List<Integer> numIslands2(int m, int n, int[][] pos) {
        root = new int[m][n][2];
        List<Integer> ans = new ArrayList<>(pos.length);
        int[][] off = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        int[][] grid = new int[m][n];
        int islands = 0;

        for (int[] po : pos) {
            int i = po[0];
            int j = po[1];
            // check to prevent re-processing of a land
            if (grid[i][j] == 0) {
                grid[i][j] = 1;
                // Assume that this new land forms an island
                islands++;
                root[i][j][0] = root[i][j][1] = -1;
                for (int[] of : off) {
                    int x = of[0] + i;
                    int y = of[1] + j;
                    // If this new land can be union(ed) with any other land, reduce island count
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && union(x, y, po[0], po[1]))
                        islands--;
                }
            }
            ans.add(islands);
        }

        return ans;
    }
}
