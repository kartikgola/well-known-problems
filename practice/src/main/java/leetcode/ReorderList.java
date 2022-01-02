/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import linkedlist.ListNode;

public class ReorderList {

    public void reorderList(ListNode head) {
        // find length of LL
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        // find middle node
        int k = 1;
        int t = len % 2 == 0 ? len/2 : len/2+1;
        curr = head;
        while (k < t) {
            curr = curr.next;
            k++;
        }

        // reverse 2nd half of the list
        ListNode prev = null;
        ListNode next = curr.next;
        curr.next = null;
        curr = next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // interleave
        ListNode p1 = head;
        ListNode p2 = prev;
        while (p1 != null && p2 != null) {
            ListNode n1 = p1.next;
            ListNode n2 = p2.next;

            p1.next = p2;
            p2.next = n1;

            p1 = n1;
            p2 = n2;
        }
    }
}
