/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

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
