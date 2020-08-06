/*
 * Author: Kartik Gola
 * Date: 8/5/20 11:38 AM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL:
 */

package leetcode;

import java.util.*;

public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if ( node == null )
            return null;

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Map<Node, Node> copies = new HashMap<>();
        copies.put(node, new Node(node.val));

        while ( !q.isEmpty() ) {
            Node u = q.poll();
            Node copy = copies.get(u);
            for ( Node v : u.neighbors ) {
                if ( !copies.containsKey(v) ) {
                    q.add(v);
                    copies.put(v, new Node(v.val));
                }
                copy.neighbors.add(copies.get(v));
            }
        }

        return copies.get(node);
    }

//    private Map<Node, Node> copies = new HashMap<>();
//
//    public Node cloneGraph(Node node) {
//        if ( node == null )
//            return null;
//
//        if ( copies.containsKey(node) )
//            return copies.get(node);
//
//        Node copy = new Node(node.val);
//        copies.put(node, copy);
//
//        for ( Node neighbor : node.neighbors )
//            copy.neighbors.add(cloneGraph(neighbor));
//
//        return copy;
//    }
}
