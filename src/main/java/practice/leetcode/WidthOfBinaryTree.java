/*
 * Author: Kartik Gola
 * Date: 09/07/20, 7:32 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import util.ds.tree.binary.TreeNode;

import util.Pair;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class WidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair(root, 1));
        q.add(null);
        int max = 0;

        int first = -1, last = -1;
        while ( !q.isEmpty() ) {
            Pair<TreeNode, Integer> p = q.poll();
            if ( p == null ) {
                max = Math.max(max, first == -1 || last == -1 ? 1 : last - first + 1);
                first = last = -1;
                if ( q.isEmpty() ) break;
                else q.add(null);
            } else {
                if ( first == -1 )
                    first = p.getValue();
                else
                    last = Math.max(last, p.getValue());

                if ( p.getKey().left != null )
                    q.add(new Pair(p.getKey().left, p.getValue() * 2 - 1));
                if ( p.getKey().right != null )
                    q.add(new Pair(p.getKey().right, p.getValue() * 2));
            }
        }

        return max;
    }

    int maxWd = 1;
    // Maps TreeNode to its relative position in a level
    Map<TreeNode, Integer> posMap = new HashMap<>();
    // Contains minimum & maximum positions at each level
    Map<Integer, Integer[]> endPosMap = new HashMap<>();

    // Calculates the position of each TreeNode relative to its level
    private void width(TreeNode root, int wd) {
        if ( root != null ) {
            posMap.put(root, wd);
            width(root.left, 2 * wd - 1);
            width(root.right, 2 * wd);
        }
    }

    // Traverses the tree & calculates least & highest positions at each level
    // Updates the maxWd variable along the way
    private void dfs(TreeNode root, int level) {
        if ( root != null ) {
            // 0th index contains least position at a level
            // 1st index contains highest position at a level
            Integer[] endPos = endPosMap.getOrDefault(level, new Integer[2]);
            int pos = posMap.get(root);
            if ( endPos[0] == null || endPos[1] == null )
                endPos[0] = endPos[1] = pos;

            // Check if current pos is lower (or greater) than least (or highest) position known at this level
            if ( endPos[0] > pos )
                endPos[0] = pos;
            else if ( endPos[1] < pos )
                endPos[1] = pos;

            // Keep updating maxWidth
            maxWd = Math.max(maxWd, endPos[1] - endPos[0] + 1);
            endPosMap.put(level, endPos);

            // Recurse for children
            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
        }
    }

    public int widthOfBinaryTreeDfs(TreeNode root) {
        width(root, 1);
        dfs(root, 0);
        return maxWd;
    }
}
