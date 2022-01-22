/*
 * Author: Kartik Gola
 * Date: 1/22/22, 10:26 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindNearestRightNodeInBinaryTree {

    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                if (q.isEmpty())
                    break;
                q.add(null);
                continue;
            }
            if (curr.val == u.val)
                return q.isEmpty() ? null : q.peek();
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }

        return null;
    }
}
