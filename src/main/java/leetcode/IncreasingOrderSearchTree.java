/*
 * Author: Kartik Gola
 * Date: 05/12/2020, 12:01
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL:
 */

package leetcode;

import ds.TreeNode;

public class IncreasingOrderSearchTree {

    // Dirty solution which works without the need of an auxiliary method
    // root.parent = right-most node of the left sub-tree
    // root.right = left-most node of the right sub-tree
    public TreeNode increasingBST(TreeNode root) {
        if (root != null) {
            TreeNode left = increasingBST(root.left);
            TreeNode right = increasingBST(root.right);
            root.left = null;
            root.right = right;

            if (left == null)
                return root;

            TreeNode rightMost = left;
            while (rightMost.right != null)
                rightMost = rightMost.right;

            rightMost.right = root;
            return left; // Always return the root of the newly formed tree!
        }
        return root;
    }

    private TreeNode newRoot = null;
    private TreeNode prevNode = null;

    private void visitNodes(TreeNode root) {
        if (root != null) {
            visitNodes(root.left);
            root.left = null;
            if (newRoot == null) {
                newRoot = root;
                prevNode = root;
            } else {
                prevNode.right = root;
                prevNode = root;
            }
            visitNodes(root.right);
        }
    }

    // Use an auxiliary method and global vars to find solution
    public TreeNode increasingBST2(TreeNode root) {
        visitNodes(root);
        return newRoot;
    }
}
