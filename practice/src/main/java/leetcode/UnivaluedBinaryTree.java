/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

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
