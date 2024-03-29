/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    // Algo - Make sure that top of stack is always a node with no left child
    // Top of stack will be the answer for next() call
    // In the next() call, we push stack.pop().right and keep pushing all its left.left.left... nodes
    public int next() {
        if (!stack.isEmpty()) {
            TreeNode root = stack.pop();
            TreeNode curr = root.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            return root.val;
        }
        return -1;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
