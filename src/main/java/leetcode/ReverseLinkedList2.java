/*
 * Author: Kartik Gola
 * Date: 6/23/21, 3:13 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/reverse-linked-list-ii/
 */

package leetcode;

import util.ds.linkedlist.ListNode;

public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;
        int pos = 1;
        ListNode dummy = new ListNode(-1), leftNode = null;
        dummy.next = head;

        for (ListNode curr = head, prev = dummy, next = head.next; curr != null; prev = curr, curr = next, pos++) {
            next = curr.next;
            if (pos >= left && pos <= right) {
                curr.next = prev;
                if (pos == left)
                    leftNode = curr;
                else if (pos == right) {
                    leftNode.next.next = curr;
                    leftNode.next = next;
                    break;
                }
            }
        }
        return dummy.next;
    }
}
