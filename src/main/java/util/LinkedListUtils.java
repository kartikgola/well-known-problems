/*
 * Author: Kartik Gola
 * Date: 07/10/2020, 21:55
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL:
 */

package util;

import ds.ListNode;

public class LinkedListUtils {

    public static int findLength(ListNode node) {
        if ( node == null )
            return 0;

        ListNode first = node,
                 second = node;

        int count = 0;
        while ( second != null && second.next != null ) {
            first = first.next;
            second = second.next.next;
            ++count;
        }

        return 2 * count + ( second == null ? 0 : 1 );
    }
}
