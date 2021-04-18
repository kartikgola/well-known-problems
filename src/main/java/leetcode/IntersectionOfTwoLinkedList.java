/*
 * Author: Kartik Gola
 * Date: 04/03/2021, 16:29
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/intersection-of-two-linked-lists/
 */

package leetcode;

import ds.linkedlist.ListNode;

public class IntersectionOfTwoLinkedList {

    public int findLength(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = findLength(headA);
        int lenB = findLength(headB);
        if (lenA < lenB) {
            int k = lenB - lenA;
            while (k-- > 0)
                headB = headB.next;
        } else if (lenA > lenB) {
            int k = lenA - lenB;
            while (k-- > 0)
                headA = headA.next;
        }
        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
