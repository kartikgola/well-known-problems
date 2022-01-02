/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import disjointset.UnionFind;

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

        return uf.getTotalGroups();
    }
}
