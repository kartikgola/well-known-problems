/*
 * Author: Kartik Gola
 * Date: 21/06/20, 4:19 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import util.ds.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt((ListNode l) -> l.val));

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