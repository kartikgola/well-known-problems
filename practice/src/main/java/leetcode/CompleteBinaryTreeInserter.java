/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeInserter {

    Queue<TreeNode> q = new LinkedList<>();
    TreeNode root = null;

    private void init(TreeNode root) {
        Queue<TreeNode> temp = new LinkedList<>();
        temp.add(root);
        while (!temp.isEmpty()) {
            TreeNode r = temp.remove();
            if (r == null) continue;
            q.add(r);
            temp.add(r.left);
            temp.add(r.right);
        }
    }

    public CompleteBinaryTreeInserter(TreeNode root) {
        this.root = root;
        this.init(root);
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        while (q.peek().left != null && q.peek().right != null)
            q.poll();
        int ans = -1;
        if (q.peek().left == null) {
            ans = q.peek().val;
            q.peek().left = node;
        } else {
            ans = q.peek().val;
            q.remove().right = node;
        }
        q.add(node);
        return ans;
    }

    public TreeNode get_root() {
        return root;
    }
}
