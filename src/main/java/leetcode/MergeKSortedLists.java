/*
 * Author: Kartik Gola
 * Date: 21/06/20, 4:19 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode l1, ListNode l2) -> {
        return l1.val - l2.val;
    });

    public ListNode mergeKLists(ListNode[] lists) {
        final int k = lists.length;
        for ( int i = 0; i < k; ++i ) {
            if ( lists[i] != null ) {
                pq.add(lists[i]);
            }
        }

        ListNode head = null,
                 curr = null,
                 p = null;

        while ( !pq.isEmpty() ) {
            p = pq.poll();

            if ( head == null )
                head = curr = p;
            else {
                curr.next = p;
                curr = curr.next;
            }

            if ( p.next != null )
                pq.add(p.next);
        }

        return head;
    }
}
