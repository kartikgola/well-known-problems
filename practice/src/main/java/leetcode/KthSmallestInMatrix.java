/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.io.IOException;
import java.util.PriorityQueue;

public class KthSmallestInMatrix {

    private Integer getKthElement(final PriorityQueue<Integer> pq, final int k) {
        if ( !pq.isEmpty() ) {
            for ( int i = 0; i < k - 1; ++i ) {
                pq.remove();
            }
            return pq.peek();
        }
        return -1;
    }

    private int kthSmallest(int[][] matrix, int k) {
        final int n = matrix.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for ( int l = 0; l < n; ++l ) {
            for ( int i = l, j = 0; j != l + 1 ; --i, ++j ) {
                pq.add(matrix[i][j]);
            }
            if ( pq.size() == k ) return getKthElement(pq, k);
        }

        for ( int l = 0; l < n - 1; ++l ) {
            for ( int i = n - 1, j = l + 1; j != n; --i, ++j ) {
                pq.add(matrix[i][j]);
            }
            if ( pq.size() == k ) return getKthElement(pq, k);
        }

        return getKthElement(pq, k);
    }

    public void solve() throws IOException {
        int[][] testData = new int[][]{{1}};
        System.out.println(kthSmallest(testData,1));
    }
}
