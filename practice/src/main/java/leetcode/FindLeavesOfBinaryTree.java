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

public class FindLeavesOfBinaryTree {

    private final Map<Integer, List<Integer>> map = new LinkedHashMap<>();

    private int dfs(TreeNode root) {
        if (root != null) {
            int max = Math.max(dfs(root.left), dfs(root.right));
            if (max == Integer.MIN_VALUE)
                max = 0;
            map.putIfAbsent(max, new ArrayList<>());
            map.get(max).add(root.val);
            return max+1;
        }
        return Integer.MIN_VALUE;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        dfs(root);
        return new ArrayList<>(map.values());
    }
}
