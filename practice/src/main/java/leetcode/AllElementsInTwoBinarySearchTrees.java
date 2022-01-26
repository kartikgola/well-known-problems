/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

import java.util.*;

public class AllElementsInTwoBinarySearchTrees {

    private final int MAX = Integer.MAX_VALUE;

    private class BSTIterator {

        private final Stack<TreeNode> stack = new Stack<>();

        BSTIterator(TreeNode root) {
            if (root != null) {
                stack.push(root);
                while (stack.peek().left != null)
                    stack.push(stack.peek().left);
            }
        }

        // top of the stack will always be the next smallest element
        // or MAX, in case stack is empty
        public int next() {
            if (stack.isEmpty())
                return MAX;
            TreeNode pop = stack.pop();
            if (pop.right != null) {
                stack.push(pop.right);
                while (stack.peek().left != null)
                    stack.push(stack.peek().left);
            }
            return pop.val;
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        BSTIterator it1 = new BSTIterator(root1);
        BSTIterator it2 = new BSTIterator(root2);

        int v1 = it1.next();
        int v2 = it2.next();

        while (v1 != MAX || v2 != MAX) {
            if (v1 != MAX && v2 != MAX) {
                if (v1 <= v2) {
                    ans.add(v1);
                    v1 = it1.next();
                } else {
                    ans.add(v2);
                    v2 = it2.next();
                }
            } else if (v1 != MAX) {
                ans.add(v1);
                v1 = it1.next();
            } else {
                ans.add(v2);
                v2 = it2.next();
            }
        }

        return ans;
    }
}
