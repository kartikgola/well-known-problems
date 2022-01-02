/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {

    public int snakesAndLadders(int[][] board) {
        final int m = board.length;
        final int n = board[0].length;
        int[] fb = new int[m * n];
        final int target = (m * n) - 1;

        boolean l2r = true; int w = 0;
        for ( int i = m - 1; i > -1; --i ) {
            for ( int j = 0; l2r && j < n; ++j )
                fb[w++] = board[i][j] == -1 ? -1 : board[i][j] - 1;
            for ( int j = n - 1; !l2r && j > -1; --j )
                fb[w++] = board[i][j] == -1 ? -1 : board[i][j] - 1;
            l2r = !l2r;
        }

        int[] dist = new int[fb.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while ( !q.isEmpty() ) {
            int size = q.size();
            while ( size-- > 0 ) {
                int x = q.poll();
                int steps = dist[x];
                if ( x == target )
                    return steps;
                else {
                    for ( int y = x + 1; y <= Math.min(x + 6, target); ++y ) {
                        int z = fb[y] > -1 ? fb[y] : y;
                        if ( dist[z] == 0 ) {
                            q.add(z);
                            dist[z] = steps + 1;
                        }
                    }
                }
            }
        }

        return -1;
    }
}
