/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if ( head == null )
            return null;

        Node _head = new Node(head.val);
        Node curr = head;
        Node prev = _head;

        // Map for mapping old nodes to their copy nodes
        Map<String, Node> cMap = new HashMap<>();
        cMap.put( head.toString(), _head );

        // Clone the list with only next pointers
        // Keep mapping {oldNode: copyNode} along the way
        while ( curr.next != null ) {
            curr = curr.next;
            Node copy = new Node(curr.val);
            cMap.put( curr.toString(), copy );
            prev.next = copy;
            prev = copy;
        }

        // Start again from beginning and set the random pointers by searching map
        // using random node's hash value to get the corresponding copy node
        curr = head;
        Node copy = _head;
        while ( curr != null ) {
            if ( curr.random == null ) {
                copy.random = null;
            } else {
                copy.random = cMap.get( curr.random.toString() );
            }
            curr = curr.next;
            copy = copy.next;
        }

        // Return copy head
        return _head;
    }

}
