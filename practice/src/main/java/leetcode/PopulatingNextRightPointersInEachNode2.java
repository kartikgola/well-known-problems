/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import linkedlist.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode2 {

    public Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node c = q.poll();
            if (c == null) {
                if (!q.isEmpty())
                    q.add(null);
                continue;
            }
            c.next = q.peek();
            if (c.left != null)
                q.add(c.left);
            if (c.right != null)
                q.add(c.right);
        }

        return root;
    }

    private void f(Node root, Node next) {
        if (root != null) {
            root.next = next;
            f(root.left, root.right);
            f(root.right, next != null ? next.left : null);
        }
    }

    public Node connectDFS(Node root) {
        f(root, null);
        return root;
    }
}
