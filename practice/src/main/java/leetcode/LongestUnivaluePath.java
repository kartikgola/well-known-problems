/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

public class LongestUnivaluePath {

    int ans = 0;

    private int f(TreeNode root, int prev) {
        if (root != null) {
            int left = f(root.left, root.val);
            int right = f(root.right, root.val);
            int nodes = 1+left+right;
            ans = Math.max(ans, nodes-1);
            return prev == root.val ? 1 + Math.max(left, right) : 0;
        }
        return 0;
    }

    public int longestUnivaluePath(TreeNode root) {
        f(root, 1001);
        return ans;
    }
}
