/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

public class LongestZigzagPathInABinaryTree {

    private int ans = 0;

    private int f(TreeNode root, boolean isLeft) {
        if (root != null) {
            int left = f(root.left, true);
            int right = f(root.right, false);
            if (isLeft) {
                ans = Math.max(ans, 1+right);
            } else {
                ans = Math.max(ans, 1+left);
            }
            return isLeft ? 1+right : 1+left;
        }
        return 0;
    }

    public int longestZigZag(TreeNode root) {
        f(root.left, true);
        f(root.right, false);
        return ans;
    }
}
