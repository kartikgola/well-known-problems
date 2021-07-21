/*
 * Author: Kartik Gola
 * Date: 06/10/2020, 20:02
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */

package practice.leetcode;

import util.ds.tree.binary.TreeNode;

public class InsertIntoABinarySearchTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if ( root != null ) {
            if ( root.val > val ) {
                root.left = insertIntoBST(root.left, val);
            } else {
                root.right = insertIntoBST(root.right, val);
            }
            return root;
        } else {
            return new TreeNode(val);
        }
    }
}
