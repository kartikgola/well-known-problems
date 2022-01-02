/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

public class AddOneRowToTree {

    private TreeNode add(TreeNode root, int v, int d, boolean isLeftChild) {
        if (root != null) {
            if (d == 1) {
                TreeNode node = new TreeNode(v);
                if (isLeftChild)
                    node.left = root;
                else
                    node.right = root;
                return node;
            } else {
                root.left = add(root.left, v, d-1, true);
                root.right = add(root.right, v, d-1, false);
            }
        } else if (d == 1)
            return new TreeNode(v);
        return root;
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        return add(root, v, d, true);
    }
}
