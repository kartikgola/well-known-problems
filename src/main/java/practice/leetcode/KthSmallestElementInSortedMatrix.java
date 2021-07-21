/*
 * Author: Kartik Gola
 * Date: 7/8/21, 11:37 AM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */

package practice.leetcode;

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
