/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package util.ds.tree.segment;

public class LazySegmentTree {

    public enum RangeQueryType {
        Minimum,
        Maximum,
        Sum
    }

    private final int[] tree;
    private final int[] lazy;
    private final RangeQueryType type;
    private final int size;
    private int NOT_FOUND;

    public LazySegmentTree(int[] arr, RangeQueryType rangeQueryType) {
        this.size = arr.length;
        this.type = rangeQueryType;
        this.tree = new int[arr.length * 4];
        this.lazy = new int[arr.length * 4];
        switch (rangeQueryType) {
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

        if ( lazy[treePos] != 0 )
            removeLaziness(treePos, low, high);

        if ( low >= i && high <= j )
            return tree[treePos];

        int mid = low + (high - low) / 2;
        int leftResult = query(2 * treePos + 1, low, mid, i, j);
        int rightResult = query(2 * treePos + 2, mid + 1, high, i, j);

        return merge(leftResult, rightResult);
    }

    private void removeLaziness(int treePos, int low, int high) {
        // remove laziness of the node
        tree[treePos] += (high - low + 1) * lazy[treePos];

        // make children lazy
        if ( low < high ) {
            lazy[2 * treePos + 1] += lazy[treePos];
            lazy[2 * treePos + 2] += lazy[treePos];
        }
        // cleanup laziness
        lazy[treePos] = 0;
    }

    private void update(int treePos, int low, int high, int i, int j, int val) {
        // check and remove laziness, if present
        if ( lazy[treePos] != 0 ) {
            removeLaziness(treePos, low, high);
        }

        // not within the range
        if ( low > j || high < i )
            return;

        // completely inside the range
        if ( low >= i && high <= j ) {
            // add to tree node, no. of elements * value to increment by
            tree[treePos] += (high - low + 1) * val;
            if ( low < high ) {
                lazy[2 * treePos + 1] += val;
                lazy[2 * treePos + 2] += val;
            }
            return;
        }

        // recurse for children as range is partially covered
        int mid = low + (high - low) / 2;
        update(2 * treePos + 1, low, mid, i, j, val);
        update(2 * treePos + 2, mid + 1, high, i, j, val);

        tree[treePos] = merge(tree[2 * treePos + 1], tree[2 * treePos + 2]);
    }

    public int query(int i, int j) {
        return query(0, 0, size - 1, i, j);
    }

    public void update(int i, int j, int val) {
        this.update(0, 0, size - 1, i, j, val);
    }

}
