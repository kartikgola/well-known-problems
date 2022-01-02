/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:45 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package util;import linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

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

    public static List<ListNode> toList(ListNode node) {
        List<ListNode> list = new ArrayList<>();
        if (node == null)
            return list;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        return list;
    }
}
