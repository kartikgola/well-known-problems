/*
 * Author: Kartik Gola
 * Date: 8/5/20 11:38 AM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/clone-graph/
 */

package practice.leetcode;

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


    private void dfs(Node u, Node uc, boolean[] vis, Map<Integer, Node> map) {
        vis[u.val] = true;
        for (Node un: u.neighbors) {
            map.putIfAbsent(un.val, new Node(un.val));
            Node ucn = map.get(un.val);
            uc.neighbors.add(ucn);
            if (!vis[ucn.val]) {
                dfs(un, ucn, vis, map);
            }
        }
    }

    public Node cloneGraph2(Node node) {
        if (node == null)
            return null;
        Map<Integer, Node> map = new HashMap<>();
        map.put(node.val, new Node(node.val));
        dfs(node, map.get(node.val), new boolean[101], map);
        return map.get(node.val);
    }
}
