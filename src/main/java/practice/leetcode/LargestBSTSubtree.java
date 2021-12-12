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

    private int ans = 0;

    private int f(TreeNode root, int max, int min) {
        if (root != null) {
            // look for BSTs wrt max and min passed by parent
            int left = f(root.left, root.val, min);
            int right = f(root.right, max, root.val);
            int size = -1;
            if (left != -1 && right != -1 && root.val < max && root.val > min) {
                size = 1 + left + right;
                ans = Math.max(ans, size);
            }

            // if the tree incl current and all the nodes below form a BST (wrt max & min passed by parent)
            // this will be the largest BST and we do not need to look for independent BSTs
            if (size > -1)
                return size;

            // look for independent BSTs starting from current node
            int ileft = f(root.left, root.val, Integer.MIN_VALUE);
            int iright = f(root.right, Integer.MAX_VALUE, root.val);
            if (ileft != -1 && iright != -1) {
                ans = Math.max(ans, 1 + ileft + iright);
            }

            return size;
        }
        return 0;
    }

    public int largestBSTSubtree2(TreeNode root) {
        f(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return ans;
    }
}
