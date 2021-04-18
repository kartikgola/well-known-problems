/*
 * Author: Kartik Gola
 * Date: 05/02/2021, 12:34
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/linked-list-cycle/
 */

package leetcode;

import ds.linkedlist.ListNode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p1 != p2 && p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1 == p2;
    }
}
