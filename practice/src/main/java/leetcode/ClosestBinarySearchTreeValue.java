/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

public class ClosestBinarySearchTreeValue {

    // Globally known closest value of a node
    private int closest = -1;

    private void closest(TreeNode root, double target) {
        if ( root != null ) {
            // Check if diff of root's val is less than diff of globally known closest root's val
            if ( Math.abs(root.val - target) < Math.abs(closest - target) )
                closest = root.val;

            // Go left or right depending on target value
            // This works even in a graph below, where target = 5.1 or 4.1 or or 5.1 or 5.9
            //      5
            //     / \
            //    4  10
            if ( target < root.val )
                closest(root.left, target);
            else
                closest(root.right, target);
        }
    }

    public int closestValue(TreeNode root, double target) {
        closest = root.val;
        closest(root, target);
        return closest;
    }
}
