/*
 * Author: Kartik Gola
 * Date: 10/11/2020, 08:58
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL:  https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 */

package leetcode;

import util.ds.tree.binary.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestor {

    int diff = 0;

    private void findMax(TreeNode root, int min, int max) {
        if ( root != null ) {
            diff = Math.max(diff, Math.max(Math.abs(min - root.val), Math.abs(max - root.val)));
            if (root.val < min) {
                min = root.val;
            }
            if (root.val > max) {
                max = root.val;
            }
            findMax(root.left, min, max);
            findMax(root.right, min, max);
        }
    }

    public int maxAncestorDiff(TreeNode root) {
        if (root != null) {
            findMax(root.left, root.val, root.val);
            findMax(root.right, root.val, root.val);
        }
        return diff;
    }
}
