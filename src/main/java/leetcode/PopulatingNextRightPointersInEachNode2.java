/*
 * Author: Kartik Gola
 * Date: 12/6/20, 7:45 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */

package leetcode;

import ds.linkedlist.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode2 {

    public Node connect(Node root) {
        if (root == null)
            return null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        Node prev = null;

        while(!q.isEmpty()) {
            Node r = q.poll();
            if (r == null) {
                prev = null;
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                if (r.left != null) {
                    q.add(r.left);
                }
                if (r.right != null) {
                    q.add(r.right);
                }
                if (prev != null) {
                    prev.next = r;
                }
                prev = r;
            }
        }

        return root;
    }
}
