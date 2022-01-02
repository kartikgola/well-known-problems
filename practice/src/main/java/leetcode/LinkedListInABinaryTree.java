/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import linkedlist.ListNode;
import tree.binary.TreeNode;

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
