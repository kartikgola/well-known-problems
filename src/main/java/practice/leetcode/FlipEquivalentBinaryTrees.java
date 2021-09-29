/*
 * Author: Kartik Gola
 * Date: 9/28/21, 9:08 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import util.ds.tree.binary.TreeNode;

public class FlipEquivalentBinaryTrees {

    public boolean flipEquiv(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null)
            return true;
        if (r1 == null || r2 == null)
            return false;
        if (r1.val != r2.val)
            return false;
        return (flipEquiv(r1.left, r2.left) && flipEquiv(r1.right, r2.right))
                || (flipEquiv(r1.left, r2.right) && flipEquiv(r1.right, r2.left));
    }
}
