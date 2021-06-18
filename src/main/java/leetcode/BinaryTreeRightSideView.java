/*
 * Author: Kartik Gola
 * Date: 2/6/21, 6:15 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/binary-tree-right-side-view/
 */

package leetcode;

import util.ds.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeRightSideView {
    private Map<Integer, Integer> map = new LinkedHashMap<>();

    private void dfs(TreeNode root, int level) {
        if (root != null) {
            map.put(level, root.val);
            dfs(root.left, level+1);
            dfs(root.right, level+1);
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return new ArrayList<>(map.values());
    }
}
