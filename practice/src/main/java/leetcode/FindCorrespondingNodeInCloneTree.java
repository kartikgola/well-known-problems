/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

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
