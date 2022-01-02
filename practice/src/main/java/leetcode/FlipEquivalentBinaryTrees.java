/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

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
