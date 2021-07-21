/*
 * Author: Kartik Gola
 * Date: 09/02/2021, 21:06
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/number-of-distinct-islands/
 */

package practice.leetcode;

import java.util.*;

public class NumberOfDistinctIslands {

    private final int[][] pos = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
    private List<List<Integer>> ones = new ArrayList<>();
    private int iOffset = 50, jOffset = 50;

    void visitIsland(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return;

        // Set min i & j
        iOffset = Math.min(iOffset, i);
        jOffset = Math.min(jOffset, j);
        ones.add(Arrays.asList(i, j));

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
                    iOffset = jOffset = 50;
                    ones.clear();

                    // Do a DFS
                    visitIsland(grid, i, j);

                    // Normalize the XY coordinates of the found island
                    // so that every island starts from 0,0
                    ones.forEach(xy -> {
                        xy.set(0, xy.get(0) - iOffset);
                        xy.set(1, xy.get(1) - jOffset);
                    });

                    // sort..
                    ones.sort((a, b) -> a.get(0) - b.get(0) != 0 ? a.get(0) - b.get(0) : a.get(1) - b.get(1));

                    // and put them in set
                    set.add(ones);
                }
            }
        }
        return set.size();
    }
}
