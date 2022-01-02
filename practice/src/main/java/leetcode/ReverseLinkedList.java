/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import linkedlist.ListNode;

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
