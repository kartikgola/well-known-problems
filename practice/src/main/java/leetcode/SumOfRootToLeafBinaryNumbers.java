/*
 * Author: Kartik Gola
 * Date: 1/11/22, 11:17 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

public class SumOfRootToLeafBinaryNumbers {

    private int sum = 0;

    private void f(TreeNode root, int prev) {
        if (root != null) {
            prev |= root.val;
            if (root.left == null && root.right == null) {
                sum += prev;
            } else {
                prev <<= 1;
                f(root.left, prev);
                f(root.right, prev);
            }
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        f(root, 0);
        return sum;
    }
}
