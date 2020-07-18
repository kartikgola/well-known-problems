/*
 * Author: Kartik Gola
 * Date: 6/12/20 12:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private List<ListNode> len(ListNode head) {
        List<ListNode> res = new ArrayList<>();
        while ( head != null ) {
            res.add(head);
            head = head.next;
        }
        return res;
    }

    private TreeNode build(List<ListNode> l, int i, int j) {
        if ( i <= j ) {
            int m = i + (j - i) / 2;
            TreeNode root = new TreeNode(l.get(m).val);
            root.left = build(l, i, m - 1);
            root.right = build(l, m + 1, j);
            return root;
        }
        return null;
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<ListNode> l = len(head);
        return build(l, 0, l.size() - 1);
    }
}