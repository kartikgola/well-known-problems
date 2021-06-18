/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import util.ds.linkedlist.ListNode;

public class RemoveNthNodeFromEndOfList {

    // @params : `i` is the index of a node in the linked list
    // @returns : length of the list
    private int remove(ListNode prev, ListNode head, int i, int n) {
        if ( head == null )
            return i;
        int len = remove(head, head.next, i + 1, n);
        if ( len - n == i ) { // Check if current node is to be removed
            if ( prev == null ) { // First node is being removed
                return -1;
            } else { // Remove the target node
                prev.next = head.next;
            }
        }
        return len;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if ( head == null || head.next == null )
            return null;
        int res = remove(null, head, 0, n);
        return res == -1 ? head.next : head;
    }
}
