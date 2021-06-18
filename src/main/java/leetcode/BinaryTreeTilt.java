/*
 * Author: Kartik Gola
 * Date: 11/8/20, 6:22 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/binary-tree-tilt/
 */

package leetcode;

import util.ds.tree.binary.TreeNode;

public class BinaryTreeTilt {

    int tilt = 0;

    private int subtreeSumOf(TreeNode root) {
        if ( root != null ) {
            final int left = subtreeSumOf(root.left);
            final int right = subtreeSumOf(root.right);
            tilt += Math.abs(left - right);
            return root.val + left + right;
        }
        return 0;
    }

    public int findTilt(TreeNode root) {
        subtreeSumOf(root);
        return tilt;
    }
}
