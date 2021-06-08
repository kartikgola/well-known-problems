/*
 * Author: Kartik Gola
 * Date: 6/8/21, 5:47 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/the-maze-ii/
 */

package leetcode;


import java.util.*;

public class TheMaze2 {

    // O(m.n.max(m,n)) BFS solution
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        final int m = maze.length, n = maze[0].length;
        final int[][] offsets = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
        final int[][] dist = new int[m][n];
        for (int[] d: dist)
            Arrays.fill(d, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 0});
        dist[start[0]][start[1]] = 0;

        while (!q.isEmpty()) {
            int i = q.peek()[0],
                j = q.poll()[1];
            for (int[] off : offsets) {
                int x = i, y = j, c = 0;
                while (x + off[0] >= 0 && x + off[0] < m && y + off[1] >= 0 && y + off[1] < n && maze[x + off[0]][y + off[1]] == 0) {
                    x += off[0];
                    y += off[1];
                    c++; // increase no. of steps taken
                }
                if (c + dist[i][j] < dist[x][y]) {
                    dist[x][y] = c + dist[i][j];
                    q.add(new int[]{x, y});
                }
            }
        }

        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }

    // O(m.n.log(mn)) Dijkstra solution
    public int shortestDistance2(int[][] maze, int[] start, int[] destination) {
        final int m = maze.length, n = maze[0].length;
        final int[][] offsets = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
        final int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int[] d: dist)
            Arrays.fill(d, Integer.MAX_VALUE);

        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(e -> e[2]));
        q.add(new int[]{start[0], start[1], 0});
        dist[start[0]][start[1]] = 0;

        while (!q.isEmpty()) {
            int i = q.peek()[0],
                j = q.peek()[1],
                d = q.poll()[2]; // distance till this point [i,j]
            if (visited[i][j])
                continue;
            visited[i][j] = true;
            for (int[] off : offsets) {
                int x = i, y = j, c = 0;
                while (x + off[0] >= 0 && x + off[0] < m && y + off[1] >= 0 && y + off[1] < n && maze[x + off[0]][y + off[1]] == 0) {
                    x += off[0];
                    y += off[1];
                    c++; // increase no. of steps taken
                }
                if (d + c < dist[x][y]) {
                    dist[x][y] = d + c;
                    q.add(new int[]{x, y, d+c});
                }
            }
        }

        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }

    // O(m.n.log(mn)) DFS solution
    private void dfs(int[][] maze, int[][] dist, int[][] offsets, int i, int j) {
        for (int[] off : offsets) {
            int x = i, y = j, c = 0;
            while (x + off[0] >= 0 && x + off[0] < maze.length && y + off[1] >= 0 && y + off[1] < maze[0].length && maze[x + off[0]][y + off[1]] == 0) {
                x += off[0];
                y += off[1];
                c++; // increase no. of steps taken
            }
            if (dist[i][j] + c < dist[x][y]) {
                dist[x][y] = dist[i][j] + c;
                dfs(maze, dist, offsets, x, y);
            }
        }
    }

    public int shortestDistance3(int[][] maze, int[] start, int[] destination) {
        final int[][] dist = new int[maze.length][maze[0].length];
        for (int[] d: dist)
            Arrays.fill(d, Integer.MAX_VALUE);
        dist[start[0]][start[1]] = 0;
        dfs(maze, dist, new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}}, start[0], start[1]);
        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }
}
