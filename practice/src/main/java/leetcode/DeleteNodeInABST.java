/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

public class DeleteNodeInABST {

    private TreeNode successor(TreeNode root) {
        if (root != null) {
            if (root.left != null)
                return successor(root.left);
            return root;
        }
        return null;
    }

    private TreeNode predecessor(TreeNode root) {
        if (root != null) {
            if (root.right != null)
                return predecessor(root.right);
            return root;
        }
        return null;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root != null) {
            if (root.val == key) {
                if (root.left == null && root.right == null) {
                    return null;
                } else if (root.right != null) {
                    // Replace current node with in-order successor's value
                    // Delete that in-order successor
                    root.val = successor(root.right).val;
                    root.right = deleteNode(root.right, root.val);
                } else {
                    // Replace current node with in-order predecessor's value
                    // Delete that in-order predecessor
                    root.val = predecessor(root.left).val;
                    root.left = deleteNode(root.left, root.val);
                }
            } else if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else {
                root.right = deleteNode(root.right, key);
            }
            return root;
        }
        return null;
    }
}
