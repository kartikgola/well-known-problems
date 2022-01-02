/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

public class BinaryTreePruning {

    private boolean prune(TreeNode root) {
        if (root != null) {
            boolean left = prune(root.left);
            boolean right = prune(root.right);
            if (!left)
                root.left = null;
            if (!right)
                root.right = null;
            if (root.val == 1)
                return true;
            return left || right;
        }
        return false;
    }

    public TreeNode pruneTree(TreeNode root) {
        return prune(root) ? root : null;
    }
}
