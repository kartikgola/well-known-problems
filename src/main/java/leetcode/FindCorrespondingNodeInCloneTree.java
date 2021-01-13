/*
 * Author: Kartik Gola
 * Date: 02/01/2021, 13:40
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 */

package leetcode;

import ds.TreeNode;

public class FindCorrespondingNodeInCloneTree {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original != null) {
            if (original == target) {
                return cloned;
            } else {
                TreeNode left = getTargetCopy(original.left, cloned.left, target);
                TreeNode right = getTargetCopy(original.right, cloned.right, target);
                return left != null ? left : right;
            }
        }
        return null;
    }
}
