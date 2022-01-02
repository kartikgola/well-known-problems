/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

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
