/*
 * Author: Kartik Gola
 * Date: 6/13/20 7:54 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package codechef.JUNE20B;

public class RangeSetTree {

    int[] tree;
    boolean[] updated;

    RangeSetTree(int m) {
        tree = new int[4 * m];
        updated = new boolean[4 * m];
    }

    void update(int p, int l, int h, int i, int j, int val) {
        final int m = l + (h - l) / 2;
        final int size = h - l + 1;
        if ( l == i && h == j ) {
            tree[p] = val;
            updated[p] = true;
            if ( l < h && (val == size || val == 0) ) {
                update(2 * p + 1, l, m, l, m, val % 2 == 0 ? val / 2 : val / 2 + 1);
                update(2 * p + 2, m + 1, h, m + 1, h, val / 2);
            }
            return;
        }

        if ( i <= m )
            update(2 * p + 1, l, m, i, j, val);
        else
            update(2 * p + 2, m + 1, h, i, j, val);

        if ( updated[2 * p + 1] ^ updated[2 * p + 2] ) {
            if ( i <= m )
                update(2 * p + 2, m + 1, h, m + 1, h, tree[p] - val);
            else
                update(2 * p + 1, l, h, l, h, tree[p] - val);
        }
    }

    int[] query(int p, int l, int h) {
        if ( l < h ) {
            if ( updated[p] ) {
                int mid = l + (h - l) / 2;
                int[] left = query(2 * p + 1, l, mid);
                if ( left[0] != -1 )
                    return left;
                else
                    return query(2 * p + 2, mid + 1, h);
            }
            return new int[]{p, l, h};
        } else if ( l == h ) {
            if ( !updated[p] )
                return new int[]{p, l, h};
        }
        return new int[]{-1, l, h};
    }

}
