/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | rattl.io
 */

package leetcode;

public class RotateList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private int getLen(ListNode head) {
        if ( head == null )
            return 0;

        int len = 0;
        ListNode fst = head, snd = head;
        while ( snd != null && snd.next != null ) {
            fst = fst.next;
            snd = snd.next.next;
            ++len;
        }

        return snd == null ? len * 2 : (len + 1) * 2 - 1;
    }

    public ListNode rotateRight(ListNode head, int k) {
        int len = getLen(head);
        if ( len == 0 )
            return null;

        k = k % len;
        if ( k == 0 )
            return head;

        ListNode curr = head, prev = null;
        for ( int i = 0; i < (len - k); ++k, prev = curr, curr = curr.next );

        ListNode newHead = curr;
        assert prev != null;
        prev.next = null;
        for ( ;curr.next != null; curr = curr.next);
        curr.next = head;

        return newHead;
    }
}
