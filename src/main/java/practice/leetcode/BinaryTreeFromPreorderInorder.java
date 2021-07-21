/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import util.ds.tree.binary.TreeNode;

public class BinaryTreeFromPreorderInorder {

    private int[] po;
    private int[] io;

    private int indexOf(int[] a, int k, int f, int t) {
        for ( int i = f; i < t; ++i ) {
            if ( a[i] == k ) {
                return i;
            }
        }
        return -1;
    }

    private TreeNode _build(int i, int j, int k, int l) {
        if ( j - i <= 0 ) return null;

        TreeNode r = new TreeNode(po[i]);

        int pi = indexOf(io, r.val, k, l);
        int lChildCount = pi - k;

        r.left = _build(i + 1, i + 1 + lChildCount, k, pi);
        r.right = _build(i + 1 + lChildCount, j, pi + 1, l);

        return r;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        io = inorder;
        return _build(0, po.length, 0, io.length);
    }

}
