/*
 * Author: Kartik Gola
 * Date: 07/10/2020, 21:55
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL:
 */

package util;

import ds.linkedlist.ListNode;

public class LinkedListUtils {

    public static int findLength(ListNode node) {
        if ( node == null )
            return 0;

        ListNode first = node,
                 second = node;

        int count = 0;
        while ( second != null && second.next != null ) {
            first = first.next;
            second = second.next.next;
            ++count;
        }

        return 2 * count + ( second == null ? 0 : 1 );
    }

    public static ListNode get(ListNode head, int index) {
        ListNode curr = head;
        while (index-- > 0) {
            curr = curr.next;
        }
        return curr;
    }

    public static ListNode add(ListNode head, ListNode node, int index) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        // -1 -> 0 -> 1
        for (int i = 0; i < index; ++i) {
            prev = prev.next;
        }
        ListNode next = prev.next;
        prev.next = node;
        node.next = next;
        return dummy.next;
    }

    public static ListNode remove(ListNode head, int index) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        for (int i = 0; i < index; ++i) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}
