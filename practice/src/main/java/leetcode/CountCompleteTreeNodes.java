/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

public class CountCompleteTreeNodes {

    private int rightDepth(TreeNode root) {
        if (root != null)
            return 1+rightDepth(root.right);
        return 0;
    }

    private int leftDepth(TreeNode root) {
        if (root != null)
            return 1+leftDepth(root.left);
        return 0;
    }

    private boolean exists(TreeNode node, int l, int r, int x) {
        if (node == null)
            return false;
        if (l == r)
            return true;
        int m = l+(r-l)/2;
        if (x <= m)
            return exists(node.left, l, m, x);
        else
            return exists(node.right, m+1, r, x);
    }

    public int countNodes(TreeNode root) {
        int ld = leftDepth(root);
        int rd = rightDepth(root);
        if (ld == rd)
            return (1 << rd)-1; // Total nodes in CBT

        // Total nodes excluding last level
        final int totalExcLast = (1 << rd)-1;

        // Initial value for binary-search's right pointer
        final int initR = (1 << (ld-1))-1;

        int l = 0, r = initR;
        while (l < r) {
            int m = l+(r-l)/2;
            if (exists(root, 0, initR, m))
                l = m+1;
            else
                r = m-1;
        }

        // After exiting, l may be pointing to right_most_node_index+1 or right_most_node_index
        if (exists(root, 0, initR, l))
            return (l+1) + totalExcLast;
        return l + totalExcLast;
    }
}
