/*
 * Author: Kartik Gola
 * Date: 8/29/21, 3:20 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import util.ds.tree.binary.TreeNode;

public class EqualTreePartition {

    private int sum(TreeNode root) {
        if (root == null)
            return 0;
        return root.val + sum(root.left) + sum(root.right);
    }

    private boolean f(TreeNode root, int prev) {
        if (root != null) {
            // we can either let go of the left edge or right edge
            int left = sum(root.left);
            int right = sum(root.right);

            // Try to cut the right edge
            if (root.right != null && left+(root.val+prev) == right)
                return true;
            // Try to cut the left edge
            else if (root.left != null && left == (root.val+prev)+right)
                return true;
            else
                // Try recursively
                return f(root.left, root.val + right + prev) || f(root.right, root.val + left + prev);
        }
        return false;
    }

    public boolean checkEqualTree(TreeNode root) {
        return f(root, 0);
    }
}
