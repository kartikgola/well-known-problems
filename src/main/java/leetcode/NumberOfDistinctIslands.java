/*
 * Author: Kartik Gola
 * Date: 09/02/2021, 21:06
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/number-of-distinct-islands/
 */

package leetcode;

import java.util.*;

public class NumberOfDistinctIslands {

    private final int[][] pos = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
    private List<List<Integer>> list = new ArrayList<>();
    private int minI = 50, minJ = 50;

    void visitIsland(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return;

        // Set min i & j
        minI = Math.min(minI, i);
        minJ = Math.min(minJ, j);
        list.add(Arrays.asList(i, j));

        grid[i][j] = 0; // mark as visited
        for (int[] p: pos)
            visitIsland(grid, i+p[0], j+p[1]);
    }

    public int numDistinctIslands(int[][] grid) {
        Set<List<List<Integer>>> set = new HashSet<>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    // Reset global stuff
                    minI = minJ = 50;
                    list.clear();

                    // Do a DFS
                    visitIsland(grid, i, j);

                    // Normalize the XY coordinates of the found island
                    list.forEach(xy -> {
                        xy.set(0, xy.get(0) - minI);
                        xy.set(1, xy.get(1) - minJ);
                    });

                    // sort..
                    list.sort((a, b) -> a.get(0) - b.get(0) != 0 ? a.get(0) - b.get(0) : a.get(1) - b.get(1));

                    // and put them in set
                    set.add(list);
                }
            }
        }
        return set.size();
    }
}
