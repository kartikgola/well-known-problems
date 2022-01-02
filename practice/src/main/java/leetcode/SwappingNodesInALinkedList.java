/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import linkedlist.ListNode;
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
