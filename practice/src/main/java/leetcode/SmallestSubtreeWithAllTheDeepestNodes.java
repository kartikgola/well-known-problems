/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

import java.util.*;

public class SmallestSubtreeWithAllTheDeepestNodes {

    private int maxDepth = 0;
    private List<TreeNode> levelNodes = new ArrayList<>();
    private final Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    private void dfs(TreeNode root, TreeNode parent, int depth) {
        if (root != null) {
            parentMap.put(root, parent);
            dfs(root.left, root, depth + 1);
            dfs(root.right, root, depth + 1);
            if (depth == maxDepth) {
                levelNodes.add(root);
            } else if (depth > maxDepth) {
                levelNodes.clear();
                maxDepth = depth;
                levelNodes.add(root);
            }
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
