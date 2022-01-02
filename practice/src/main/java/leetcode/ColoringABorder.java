/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class ColoringABorder {

    private final int[][] pos = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};

    // mark all the cells with value equal to color as -1
    private void mark(int[][] grid, int i, int j, int color) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1 || grid[i][j] != color)
            return;
        grid[i][j] = -1;
        for (int[] p: pos) {
            int x = i + p[0];
            int y = j + p[1];
            mark(grid, x, y, color);
        }
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int ogColor = grid[row][col];
        mark(grid, row, col, ogColor);
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == -1) {
                    for (int[] p: pos) {
                        int x = p[0] + i;
                        int y = p[1] + j;
                        // check if current cell touches grid border or some unvisited + different color cell
                        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || (grid[x][y] > 0 && grid[x][y] != ogColor)) {
                            grid[i][j] = -2;
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                // -2 values are border cells
                if (grid[i][j] == -2)
                    grid[i][j] = color;
                // -1 values are surrounded cells
                else if (grid[i][j] == -1)
                    grid[i][j] = ogColor;
            }
        }
        return grid;
    }
}
