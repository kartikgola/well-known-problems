/*
 * Author: Kartik Gola
 * Date: 12/13/20, 12:29 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes
 */

package leetcode;

import ds.TreeNode;

import java.util.*;

public class SmallestSubtreeWithAllTheDeepestNodes {

    private int maxDepth = 0;
    private List<TreeNode> levelNodes = new ArrayList<>();
    private final Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    private void dfs(TreeNode root, TreeNode parent, int offset) {
        if (root != null) {
            parentMap.put(root, parent);
            if (offset == maxDepth) {
                levelNodes.add(root);
            } else if (offset > maxDepth) {
                levelNodes = new ArrayList<>();
                maxDepth = offset;
                levelNodes.add(root);
            }
            dfs(root.left, root, offset + 1);
            dfs(root.right, root, offset + 1);
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, null, 0);
        Set<TreeNode> levelSet = new HashSet<>(levelNodes);
        Set<TreeNode> tempSet = new HashSet<>();

        while (levelSet.size() > 1) {
            for (TreeNode node: levelSet) {
                tempSet.add(parentMap.get(node));
            }
            levelSet = tempSet;
            tempSet = new HashSet<>();
        }
        return !levelSet.isEmpty() ? levelSet.iterator().next() : null;
    }
}