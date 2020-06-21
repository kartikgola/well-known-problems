/*
 * Author: Kartik Gola
 * Date: 21/06/20, 2:36 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

public class SubtreeOfAnotherTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private boolean isSubtree(TreeNode s, TreeNode t, boolean prevMatch) {
        if ( s == null && t == null )
            return true;

        if ( s == null || t == null )
            return false;

        // If root value is equal, we try to match left sub-tree & right sub-tree
        // We also let the recursive fn know that we have a successful match till now
        if ( s.val == t.val && isSubtree(s.left, t.left, true) && isSubtree(s.right, t.right, true) )
            return true;

        // Check if T lies completely in left sub-tree or right sub-tree
        // This is done to prevent partial matching of subtree
        // Only happens, when we have not matched any previous values
        if ( !prevMatch )
            return isSubtree(s.left, t, prevMatch) || isSubtree(s.right, t, prevMatch);

        return false;
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return isSubtree(s, t, false);
    }

}
