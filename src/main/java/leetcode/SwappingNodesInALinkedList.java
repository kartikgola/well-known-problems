/*
 * Author: Kartik Gola
 * Date: 3/20/21, 1:16 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package leetcode;

import util.ds.linkedlist.ListNode;
import util.LinkedListUtils;

public class SwappingNodesInALinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        final int n = LinkedListUtils.findLength(head);
        if (n <= 1)
            return head;

        ListNode begin = head;
        for (int i = 0; i < k - 1; ++i) {
            begin = begin.next;
        }

        ListNode end = head;
        for (int i = 0; i < n - k; ++i) {
            end = end.next;
        }

        int temp = begin.val;
        begin.val = end.val;
        end.val = temp;

        return head;
    }
}
