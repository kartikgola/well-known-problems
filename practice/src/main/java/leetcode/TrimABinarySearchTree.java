/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

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
