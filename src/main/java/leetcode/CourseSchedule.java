/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | rattl.io
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    //TODO
    private boolean hasCycleBFS(boolean[] visited, boolean[] stack, int v) {
        Stack<Integer> st = new Stack<>();
        st.push(v);

        while ( !st.empty() ) {

        }

        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites)  {
        if ( numCourses == 0 )
            return true;

        adj = new ArrayList<>();
        for ( int i = 0; i < numCourses; ++i )
            adj.add(new ArrayList<Integer>());

        for ( int[] p : prerequisites )
            adj.get(p[0]).add( p[1] );

        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];

        for ( int v = 0; v < numCourses; ++v ) {
            if ( hasCycleDFS(visited, stack, v) )
                return false;
        }

        return true;
    }
}
