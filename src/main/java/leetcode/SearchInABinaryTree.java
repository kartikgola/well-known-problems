/*
 * Author: Kartik Gola
 * Date: 27/11/2020, 22:10
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/search-in-a-binary-search-tree/
 */

package leetcode;

import util.ds.tree.binary.TreeNode;

public class SearchInABinaryTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        else if (root.val == val)
            return root;
        else if (root.val < val)
            return searchBST(root.right, val);
        else
            return searchBST(root.left, val);
    }
}
