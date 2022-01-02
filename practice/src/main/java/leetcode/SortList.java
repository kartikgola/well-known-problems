/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import linkedlist.ListNode;

import java.util.*;

public class SortList {

    // TODO: Solve in O(1) space
    public ListNode sortList(ListNode head) {
        Map<Integer, List<ListNode>> map = new HashMap<>();
        ListNode curr = head;
        while ( curr != null ) {
            map.putIfAbsent(curr.val, new ArrayList<>());
            map.get(curr.val).add(curr);
            curr = curr.next;
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort(Comparator.comparingInt((Integer a) -> a));
        ListNode prev = new ListNode(-1);
        ListNode newHead = prev;
        for ( Integer key : keys ) {
            for ( ListNode node : map.get(key) ) {
                prev.next = node;
                prev = node;
            }
        }
        prev.next = null;
        return newHead.next;
    }
}
