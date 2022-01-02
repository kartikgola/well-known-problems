/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class FlattenAMultilevelDoublyLinkedList {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {
        if ( head != null ) {
            Node flatChild = flatten(head.child);
            Node flatNext = flatten(head.next);

            if ( flatChild != null ) {
                head.next = flatChild;
                flatChild.prev = head;
                while ( flatChild.next != null ) {
                    flatChild = flatChild.next;
                }
            }

            if ( flatNext != null ) {
                if ( flatChild != null ) {
                    flatNext.prev = flatChild;
                    flatChild.next = flatNext;
                } else {
                    flatNext.prev = head;
                }
            }

            head.child = null;
            return head;
        }
        return null;
    }
}
