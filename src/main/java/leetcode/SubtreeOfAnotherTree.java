/*
 * Author: Kartik Gola
 * Date: 21/06/20, 2:36 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import ds.TreeNode;

public class SubtreeOfAnotherTree {

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
