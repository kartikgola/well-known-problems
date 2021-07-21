/*
 * Author: Kartik Gola
 * Date: 08/07/20, 11:15 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import util.ds.tree.binary.TreeNode;

public class BinaryTreeMaximumPathSum {

    private int max = Integer.MIN_VALUE;

    private int maxSum(TreeNode root) {
        if ( root != null ) {
            int left = maxSum(root.left);
            int right = maxSum(root.right);

            // Set the maximum using
            // max = max{root.val, root.val + left, root.val + right, root.val + left + right}
            int sum = root.val;
            if ( left > 0 )
                sum += left;
            if ( right > 0 )
                sum += right;
            if ( max < sum )
                max = sum;

            // Return only the maximum sum that forms a PATH with root node at one end
            // A path goes from a node to another node
            // So, we cannot just return 'sum' here.
            return Math.max(root.val, root.val + Math.max(left, right));
        }
        return 0;
    }

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }
}
