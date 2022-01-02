/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

public class CountGoodNodesInBinaryTree {

    private int goodNodes(TreeNode root, int max) {
        if (root != null) {
            if (root.val >= max)
                return 1 + goodNodes(root.left, root.val) + goodNodes(root.right, root.val);
            return goodNodes(root.left, max) + goodNodes(root.right, max);
        }
        return 0;
    }

    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }
}
