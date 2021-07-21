/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.*;

public class CourseSchedule {

    List<List<Integer>> adj;

    private boolean hasCycleDFS(boolean[] visited, boolean[] stack, int v) {
        if ( !visited[v] ) {
            visited[v] = true;
            stack[v] = true;

            for ( Integer neighbor : adj.get(v) ) {
                if ( !visited[neighbor] ) {
                    if ( hasCycleDFS(visited, stack, neighbor) )
                        return true;
                } else if ( stack[neighbor] )
                    return true;
            }
        }
        stack[v] = false;
        return false;
    }

    private boolean hasCycleBFS(int[] indegrees) {
        final int n = indegrees.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        for ( int i = 0; i < indegrees.length; ++i )
            if ( indegrees[i] == 0 ) {
                q.add(i);
                vis[i] = true;
            }

        int completedCourses = 0;
        while ( !q.isEmpty() ) {
            int u = q.poll();
            completedCourses++;
            for ( Integer v : adj.get(u) ) {
                if ( !vis[v] && --indegrees[v] == 0 ) {
                    q.add(v);
                }
            }
        }

        return completedCourses != n;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites)  {
        if ( numCourses == 0 )
            return true;

        adj = new ArrayList<>();
        for ( int i = 0; i < numCourses; ++i )
            adj.add(new ArrayList<Integer>());

        int[] indegrees = new int[numCourses];
        for ( int[] p : prerequisites ) {
            adj.get(p[0]).add(p[1]);
            indegrees[p[1]]++;
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];

        for ( int v = 0; v < numCourses; ++v ) {
            if ( hasCycleDFS(visited, stack, v) )
                return false;
        }

        // Or, with BFS approach
        // return hasCycleBFS(indegrees);
        return true;
    }
}
