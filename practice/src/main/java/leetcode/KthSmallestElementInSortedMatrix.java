/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        final int m = matrix.length, n = matrix[0].length;
        // tuple of (value, row, column)
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int j = 0; j < n; ++j)
            pq.add(new int[]{matrix[0][j], 0, j});

        int ans = 0;
        while (!pq.isEmpty() && k-- > 0) {
            int[] top = pq.poll();
            ans = top[0];
            if (top[1]+1 < m) {
                pq.add(new int[]{matrix[top[1]+1][top[2]], top[1]+1, top[2]});
            }
        }

        return ans;
    }
}
