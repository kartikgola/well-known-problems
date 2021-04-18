/*
 * Author: Kartik Gola
 * Date: 6/12/20 11:21 AM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import ds.linkedlist.ListNode;

public class SplitLinkedListInParts {

    private int getLen(ListNode head) {
        if ( head == null )
            return 0;
        int c = 1;
        ListNode sl = head, fs = head;
        while ( fs != null && fs.next != null ) {
            sl = sl.next;
            fs = fs.next.next;
            ++c;
        }
        if ( fs == null ) return 2 * c - 2;
        else return 2 * c - 1;
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = getLen(root);
        int extras = len > k ? len % k : 0;// These are extras
        int eachCount = len / k == 0 ? 1 : len / k;
        ListNode[] list = new ListNode[k];

        int i = 0, j = 0;
        ListNode prev = null;
        for ( ListNode curr = root; curr != null; curr = curr.next, ++j ) {
            if ( j == 0 ) {
                if ( prev != null )
                    prev.next = null;
                list[i] = curr;
                i++;
            }
            if ( j == eachCount - 1 && extras == 0 ) {
                j = -1;
            } else if ( j == eachCount && extras > 0 ) {
                j = -1;
                extras--;
            }
            prev = curr;
        }

        return list;
    }
}
