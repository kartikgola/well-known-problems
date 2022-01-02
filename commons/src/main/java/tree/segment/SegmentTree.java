/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package tree.segment;

public class SegmentTree {

    private final int[] tree;
    private final RangeQueryType type;
    private final int size;
    private final int NOT_FOUND;

    public SegmentTree(int[] arr, RangeQueryType type) {
        this.size = arr.length;
        this.tree = new int[arr.length * 4];
        this.type = type;
        this.NOT_FOUND = type.getDefault();
        this.build(arr, 0, 0, arr.length - 1);
    }

    private void build(int[] arr, int treePos, int low, int high) {
        if ( low == high ) {
            tree[treePos] = arr[low];
            return;
        }

        int mid = low + (high - low) / 2;
        build(arr, 2 * treePos + 1, low, mid);
        build(arr, 2 * treePos + 2, mid + 1, high);

        tree[treePos] = type.merge(tree[2 * treePos + 1], tree[2 * treePos + 2]);
    }

    private int query(int treePos, int low, int high, int i, int j) {
        if ( low > j || high < i )
            return NOT_FOUND;
        if ( low >= i && high <= j )
            return tree[treePos];

        int mid = low + (high - low) / 2;

        int leftResult = query(2 * treePos + 1, low, mid, i, j);
        int rightResult = query(2 * treePos + 2, mid + 1, high, i, j);

        return type.merge(leftResult, rightResult);
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

        tree[treePos] = type.merge(tree[2 * treePos + 1], tree[2 * treePos + 2]);
    }

    public int query(int i, int j) {
        return query(0, 0, size - 1, i, j);
    }

    public void update(int i, int val) {
        this.update(0, 0, size - 1, i, val);
    }
}
