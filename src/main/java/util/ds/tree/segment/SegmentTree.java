/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package util.ds.tree.segment;

public class SegmentTree {

    public enum RangeQueryType {
        Minimum,
        Maximum,
        Sum
    }

    private final int[] tree;
    private final RangeQueryType type;
    private final int size;
    private int NOT_FOUND;

    public SegmentTree(int[] arr, RangeQueryType type) {
        this.size = arr.length;
        this.tree = new int[arr.length * 4];
        this.type = type;
        switch (type) {
            case Sum: NOT_FOUND = 0; break;
            case Maximum: NOT_FOUND = Integer.MIN_VALUE; break;
            case Minimum: NOT_FOUND = Integer.MAX_VALUE; break;
        }
        this.build(arr, 0, 0, arr.length - 1);
    }

    private int merge(int val1, int val2) {
        switch (this.type) {
            case Maximum: return Math.max(val1, val2);
            case Minimum: return Math.min(val1, val2);
            case Sum: return val1+val2;
        }
        return -1;
    }

    private void build(int[] arr, int treePos, int low, int high) {
        if ( low == high ) {
            tree[treePos] = arr[low];
            return;
        }

        int mid = low + (high - low) / 2;
        build(arr, 2 * treePos + 1, low, mid);
        build(arr, 2 * treePos + 2, mid + 1, high);

        tree[treePos] = merge(tree[2 * treePos + 1], tree[2 * treePos + 2]);
    }

    private int query(int treePos, int low, int high, int i, int j) {
        if ( low > j || high < i )
            return NOT_FOUND;
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
        return query(0, 0, size - 1, i, j);
    }

    public void update(int i, int val) {
        this.update(0, 0, size - 1, i, val);
    }
}
