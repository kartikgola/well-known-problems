/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import linkedlist.ListNode;

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
