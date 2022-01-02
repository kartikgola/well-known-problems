/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import linkedlist.ListNode;

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101);
        ListNode curr = head, prev = dummy;

        while (curr != null) {
            if (curr.val != prev.val) {
                prev.next = curr;
                prev = curr;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }

        return dummy.next;
    }
}
