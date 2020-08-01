/*
 * Author: Kartik Gola
 * Date: 7/26/20 7:56 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import ds.UnionFind;

public class FriendCircles {

    public int findCircleNum(int[][] M) {
        final int n = M.length;
        UnionFind uf = new UnionFind(n);

        for ( int i = 0; i < n; ++i ) {
            for ( int j = i + 1; j < n; ++j ) {
                if ( M[i][j] == 1 ) {
                    uf.union(i, j);
                }
            }
        }

        return uf.getUnionsCount();
    }
}
