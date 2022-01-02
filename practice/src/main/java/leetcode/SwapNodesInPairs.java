/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import linkedlist.ListNode;

public class SwapNodesInPairs {

    // Iterative implementation
    public ListNode swapPairs(ListNode head) {
        if ( head == null || head.next == null )
            return head;

        ListNode prev = null, newHead = null;
        ListNode fst = head, snd = head.next;

        while ( fst != null && snd != null ) {
            if ( newHead == null ) {
                newHead = snd;
            }
            ListNode temp = snd.next;
            snd.next = fst;
            fst.next = temp;
            if ( prev != null ) {
                prev.next = snd;
            }
            prev = fst;
            fst = fst.next;
            snd = fst != null ? fst.next : null;
        }

        return newHead;
    }

    // Recursive implementation
    public ListNode swapPairs2(ListNode head) {
        if (head == null)
            return null;
        ListNode second = head.next;
        if (second != null) {
            ListNode third = second.next;
            second.next = head;
            head.next = swapPairs2(third);
            return second;
        }
        return head;
    }
}
