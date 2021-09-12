/*
 * Author: Kartik Gola
 * Date: 9/12/21, 11:49 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import util.ds.tree.binary.TreeNode;

public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;
        boolean res = true;
        if (root.left != null)
            res &= root.left.val == root.val;
        if (root.right != null)
            res &= root.right.val == root.val;
        return res && isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
