/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {

    private String swap(String s, int i, int j) {
        char[] ans = s.toCharArray();
        char t = ans[i];
        ans[i] = ans[j];
        ans[j] = t;
        return new String(ans);
    }

    public int slidingPuzzle(int[][] board) {
        final String target = "123450";
        final int[][] pos = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};

        // tuple of (dist, board_string)
        Queue<Pair<Integer, String>> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        // Convert input board to String
        char[] arr = new char[6];
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                arr[j+i*3] = Character.forDigit(board[i][j], 10);
            }
        }
        q.add(new Pair<>(0, new String(arr)));

        while (!q.isEmpty()) {
            Pair<Integer, String> pa = q.poll();
            int dist = pa.getKey();
            String sb = pa.getValue();
            if (vis.contains(sb))
                continue;
            if (sb.equals(target))
                return dist;
            vis.add(sb);

            int i = sb.indexOf("0");
            for (int[] p: pos) {
                // 1D => 2D
                int x = (i/3) + p[0];
                int y = (i%3) + p[1];
                // Make sure to-be-swapped value is not out of board
                if (x >= 0 && x < 2 && y >= 0 && y < 3) {
                    int j = x * 3 + y; // 2D => 1D
                    q.add(new Pair<>(dist+1, swap(sb, i, j)));
                }
            }
        }

        return -1;
    }
}
