/*
 * Author: Kartik Gola
 * Date: 3/20/21, 1:16 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: 
 */

package ds.linkedlist;

public class DoublyNode<T> {

    public T key;
    public T val;
    public DoublyNode<T> prev;
    public DoublyNode<T> next;

    public DoublyNode() {}

    public DoublyNode(T _key, T _val) {
        this.key = _key;
        this.val = _val;
    }

    public DoublyNode(T val, DoublyNode<T> prev, DoublyNode<T> next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
