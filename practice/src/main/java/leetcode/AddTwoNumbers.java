/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import linkedlist.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1 -> 8 : 81
        // 2 -> 3 : 32
        // 3 -> 1 -> 1 : 113
        ListNode head = null, curr = null, prev = null;
        int carry = 0, sum = 0;

        while ( l1 != null || l2 != null ) {
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = sum / 10;
            sum = sum % 10;

            if ( head == null ) {
                head = new ListNode(sum);
                curr = head;
                prev = curr;
            } else {
                curr = new ListNode(sum);
                prev.next = curr;
                prev = curr;
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if ( carry > 0 )
            prev.next = new ListNode(carry);

        return head;
    }

}
