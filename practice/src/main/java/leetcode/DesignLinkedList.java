/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class DesignLinkedList {

    class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    Node head = null;

    /** Initialize your data structure here. */
    public DesignLinkedList() {

    }

    private Node getNodeAt(int index) {
        if ( head == null )
            return null;
        Node curr = head;
        for ( int i = 0; i < index; ++i ) {
            curr = curr.next;
            if ( curr == null )
                return null;
        }
        return curr;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node node = getNodeAt(index);
        if ( node == null )
            return -1;
        return node.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if ( head == null ) {
            head = new Node(val);
        } else {
            Node temp = head;
            head = new Node(val);
            head.next = temp;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if ( head == null ) {
            head = new Node(val);
            return;
        }

        Node curr = head;
        while ( curr.next != null ) {
            curr = curr.next;
        }

        curr.next = new Node(val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if ( index == 0 ) {
            addAtHead(val);
            return;
        } else {
            Node prev = getNodeAt(index - 1);
            if ( prev != null ) {
                Node temp = prev.next;
                prev.next = new Node(val);
                prev.next.next = temp;
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if ( head != null ) {
            if ( index == 0 ) {
                head = head.next;
            } else {
                Node prev = getNodeAt(index - 1);
                if ( prev != null && prev.next != null ) {
                    prev.next = prev.next.next;
                }
            }
        }
    }
}
