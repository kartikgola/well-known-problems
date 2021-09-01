/*
 * Author: Kartik Gola
 * Date: 9/1/21, 10:45 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import util.ds.tree.binary.TreeNode;

public class MaximumAverageSubtree {

    private double ans = 0.0;

    private int[] f(TreeNode root) {
        if (root != null) {
            int[] l = f(root.left);
            int[] r = f(root.right);
            ans = Math.max(ans, ((double) root.val+l[0]+r[0]) / (1+l[1]+r[1]));
            return new int[]{root.val+l[0]+r[0], 1+l[1]+r[1]};
        }
        return new int[]{0, 0};
    }

    public double maximumAverageSubtree(TreeNode root) {
        f(root);
        return ans;
    }
}
