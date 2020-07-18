/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package ds;

import java.util.Arrays;

public class SegmentTree {

    public enum RangeQueryType {
        Minimum,
        Maximum,
        Sum
    }

    private int[] tree;
    private int[] arr;
    private RangeQueryType type;

    public SegmentTree(int[] arr, RangeQueryType type) {
        this.tree = new int[arr.length * 4];
        this.arr = arr;
        this.type = type;
        this.build(0, 0, arr.length - 1);
    }

    private int merge(int val1, int val2) {
        int res = -1;
        if ( type == RangeQueryType.Maximum ) {
            res = Math.max(val1, val2);
        } else if ( type == RangeQueryType.Minimum ) {
            res = Math.min(val1, val2);
        } else if ( type == RangeQueryType.Sum) {
            res = val1 + val2;
        }
        return res;
    }

    private void build(int treePos, int low, int high) {
        if ( low == high ) {
            tree[treePos] = arr[low];
            return;
        }

        int mid = low + (high - low) / 2;
        build(2 * treePos + 1, low, mid);
        build(2 * treePos + 2, mid + 1, high);

        tree[treePos] = merge(tree[2 * treePos + 1], tree[2 * treePos + 2]);
    }

    private int query(int treePos, int low, int high, int i, int j) {
        if ( low > j || high < i )
            return 0;
        if ( low >= i && high <= j )
            return tree[treePos];

        int mid = low + (high - low) / 2;

        int leftResult = query(2 * treePos + 1, low, mid, i, j);
        int rightResult = query(2 * treePos + 2, mid + 1, high, i, j);

        return merge(leftResult, rightResult);
    }

    private void update(int treePos, int low, int high, int i, int val) {
        if ( low == high ) {
            tree[treePos] = val;
            return;
        }

        int mid = low + (high - low) / 2;
        if ( i <= mid ) {
            update(2 * treePos + 1, low, mid, i, val);
        } else {
            update(2 * treePos + 2, mid + 1, high, i, val);
        }

        tree[treePos] = merge(tree[2 * treePos + 1], tree[2 * treePos + 2]);
    }

    public int query(int i, int j) {
        return query(0, 0, arr.length - 1, i, j);
    }

    public void update(int i, int val) {
        this.arr[i] = val;
        this.update(0, 0, arr.length - 1, i, val);
    }
}
