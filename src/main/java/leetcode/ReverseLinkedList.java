/*
 * Author: Kartik Gola
 * Date: 27/11/2020, 21:48
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/reverse-linked-list/
 */

package leetcode;

import ds.ListNode;

public class ReverseLinkedList {

    ListNode last = null;

    public void reverseList(ListNode prev, ListNode curr) {
        if (curr != null) {
            reverseList(curr, curr.next);
            curr.next = prev;
            if (last == null)
                last = curr;
        }
    }

    public ListNode reverseList(ListNode head) {
        reverseList(null, head);
        return last;
    }
}
