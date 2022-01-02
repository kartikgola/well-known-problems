/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import linkedlist.ListNode;

import java.util.Random;

public class LinkedListRandomNode {

    private int size = 0;
    private ListNode head;
    private final Random rand = new Random();

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        while (head != null) {
            size++;
            head = head.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        final int randInt = rand.nextInt(size);
        int i = 0;
        ListNode curr = this.head;

        while (i < randInt) {
            curr = curr.next;
            i++;
        }
        return curr.val;
    }
}
