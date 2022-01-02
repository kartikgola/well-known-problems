/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import linkedlist.ListNode;
import util.LinkedListUtils;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        int len = LinkedListUtils.findLength(head);
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
