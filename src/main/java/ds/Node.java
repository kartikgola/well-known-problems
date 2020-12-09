/*
 * Author: Kartik Gola
 * Date: 12/6/20, 7:46 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL:
 */

package ds;

public class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        this.val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        this.val = _val;
        this.left = _left;
        this.right = _right;
        this.next = _next;
    }
}
