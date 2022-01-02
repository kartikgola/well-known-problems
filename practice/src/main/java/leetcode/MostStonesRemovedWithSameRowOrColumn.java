/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import disjointset.UnionFind;

public class MostStonesRemovedWithSameRowOrColumn {

    public int removeStones(int[][] stones) {
        final int n = stones.length;
        UnionFind unionFind = new UnionFind(n);
        for ( int i = 0; i < n; ++i ) {
            for ( int j = i + 1; j < n; ++j ) {
                if ( stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1] )
                    unionFind.union(i, j);
            }
        }
        return n - unionFind.getTotalGroups();
    }
}
