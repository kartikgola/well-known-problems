/*
 * Author: Kartik Gola
 * Date: 03/02/2021, 08:52
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/trim-a-binary-search-tree/
 */

package leetcode;

import util.ds.tree.binary.TreeNode;

public class TrimABinarySearchTree {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root != null) {
            if (root.val > low && root.val < high) {
                root.left = trimBST(root.left, low, high);
                root.right = trimBST(root.right, low, high);
            } else if (root.val < low) {
                return trimBST(root.right, low, high);
            } else if (root.val > high) {
                return trimBST(root.left, low, high);
            } else if (root.val == low) {
                root.left = null;
                root.right = trimBST(root.right, low, high);
            } else {
                root.right = null;
                root.left = trimBST(root.left, low, high);
            }
        }
        return root;
    }
}
