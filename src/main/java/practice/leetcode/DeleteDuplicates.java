/*
 * Author: Kartik Gola
 * Date: 21/01/2021, 22:54
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */

package practice.leetcode;

import util.ds.linkedlist.ListNode;

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
