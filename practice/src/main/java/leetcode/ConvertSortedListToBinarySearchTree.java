/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import linkedlist.ListNode;
import tree.binary.TreeNode;
import util.LinkedListUtils;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {

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
        List<ListNode> l = LinkedListUtils.toList(head);
        return build(l, 0, l.size() - 1);
    }
}
