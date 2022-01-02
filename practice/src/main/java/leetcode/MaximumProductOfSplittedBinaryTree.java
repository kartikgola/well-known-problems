/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MaximumProductOfSplittedBinaryTree {

    private final long MOD = 1000_000_007;

    Map<TreeNode, Long> dp = new HashMap<>();

    private long sum(TreeNode root) {
        dp.putIfAbsent(root, root == null ? 0 : root.val + sum(root.left) + sum(root.right));
        return dp.get(root);
    }

    private long prod(TreeNode root, long backSum) {
        if (root != null) {
            long left = sum(root.left);
            long right = sum(root.right);
            return Math.max(
                    // Cut the left edge or right edge
                    Math.max(left*(root.val+right+backSum), (left+root.val+backSum)*right),
                    // Repeat for children
                    Math.max(prod(root.left, backSum+root.val+right), prod(root.right, backSum+root.val+left))
            );
        }
        return 0;
    }

    public int maxProduct(TreeNode root) {
        return (int)(prod(root, 0) % MOD);
    }
}
