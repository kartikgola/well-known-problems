/*
 * Author: Kartik Gola
 * Date: 11/07/20, 7:43 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import ds.TreeNode;

public class ValidateBinarySearchTree {

    private boolean valid(TreeNode root, long min, long max) {
        if ( root != null ) {
            if ( root.val > min && root.val < max )
                return valid(root.left, min, root.val) && valid(root.right, root.val, max);
            return false;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
