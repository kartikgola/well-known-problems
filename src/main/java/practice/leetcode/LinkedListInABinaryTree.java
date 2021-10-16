/*
 * Author: Kartik Gola
 * Date: 10/12/21, 10:20 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import util.ds.linkedlist.ListNode;
import util.ds.tree.binary.TreeNode;

public class LinkedListInABinaryTree {

    // Checks consecutive values of linked-list and root values
    private boolean f(ListNode head, TreeNode root) {
        if (head == null)
            return true;
        if (root == null)
            return false;
        return head.val == root.val && (f(head.next, root.left) || f(head.next, root.right));
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null)
            return true;
        if (root == null)
            return false;
        return f(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}
