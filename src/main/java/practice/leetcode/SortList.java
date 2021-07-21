/*
 * Author: Kartik Gola
 * Date: 14/10/2020, 19:07
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/sort-list/
 */

package practice.leetcode;

import util.ds.linkedlist.ListNode;

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
