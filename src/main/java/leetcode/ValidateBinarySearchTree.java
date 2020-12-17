/*
 * Author: Kartik Gola
 * Date: 11/07/20, 7:43 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/validate-binary-search-tree/
 */

package leetcode;

import ds.TreeNode;

public class ValidateBinarySearchTree {

    private Boolean isValid(TreeNode root, Integer MIN_VALUE, Integer MAX_VALUE) {
        if (root != null) {
            return (MIN_VALUE == null || root.val > MIN_VALUE)
                    && (MAX_VALUE == null || root.val < MAX_VALUE)
                    && isValid(root.left, MIN_VALUE, root.val)
                    && isValid(root.right, root.val, MAX_VALUE);
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
}
