/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

public class ConvertBSTToGreaterTree {

    private Integer traverse(TreeNode root, int greaterSum) {
        if (root != null) {
            int rightSum = traverse(root.right, greaterSum);
            // All left nodes should get the extra greaterSum as `root.val + rightSum + greaterSum`
            // because this is the sum of values that are greater than left subtree
            int leftSum = traverse(root.left, root.val + rightSum + greaterSum);

            // Only 'rightSum + greaterSum' should added to root.val since this indicates sum
            // of all greater values from other known areas(greaterSum) + right subtree(rightSum)
            root.val += rightSum + greaterSum;

            // The return value, however, should only be 'leftSum + root.val + rightSum'
            // since the parent of current node would already have accounted for 'greaterSum'
            return root.val + leftSum - greaterSum;
        }
        return 0;
    }

    public TreeNode convertBST(TreeNode root) {
        traverse(root, 0);
        return root;
    }

}
