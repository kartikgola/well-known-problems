/*
 * Author: Kartik Gola
 * Date: 12/11/21, 4:40 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import util.ds.tree.binary.TreeNode;

public class LargestBSTSubtree {

    // Track previous node while doing inorder traversal.
    // previous at every stage of DFS will in-order predecessor of current node
    private TreeNode previous;

    // Function to check if given tree is a valid Binary Search Tree or not.
    private boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if(!isValidBST(root.left))
            return false;
        if (previous != null && previous.val >= root.val)
            return false;
        previous = root;
        return isValidBST(root.right);
    }

    private int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int largestBSTSubtree(TreeNode root) {
        if (root == null)
            return 0;
        previous = null;
        if (isValidBST(root))
            return countNodes(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }


//    // This bad boy times out on bigger testcases (passes 71/73) since it lacks the ability to re-use results
//    private int ans = 0;
//
//    private int f(TreeNode root, int min, int max) {
//        if (root != null) {
//            // Check for BSTs below using current node as root and ignoring (min, max) values that are passed by parent
//            int ileft = f(root.left, Integer.MIN_VALUE, root.val);
//            int iright = f(root.right, root.val, Integer.MAX_VALUE);
//            if (ileft != -1 && iright != -1) {
//                ans = Math.max(ans, 1 + ileft + iright);
//            }
//
//            // Check for BSTs below using current node AND (min, max) values passed by parent
//            int left = f(root.left, root.val, min);
//            int right = f(root.right, max, root.val);
//            if (left != -1 && right != -1 && root.val < max && root.val > min) {
//                ans = Math.max(ans, 1 + left + right);
//                return 1 + left + right;
//            }
//            return -1;
//        }
//        return 0;
//    }
//
//    public int largestBSTSubtree(TreeNode root) {
//        f(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
//        return ans;
//    }
}
