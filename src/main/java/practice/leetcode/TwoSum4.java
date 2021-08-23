/*
 * Author: Kartik Gola
 * Date: 8/23/21, 1:33 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import util.ds.tree.binary.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class TwoSum4 {

    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root != null) {
            if (set.contains(root.val))
                return true;
            set.add(k - root.val);
            return findTarget(root.left, k) || findTarget(root.right, k);
        }
        return false;
    }
}
