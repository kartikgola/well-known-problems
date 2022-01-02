/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

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
