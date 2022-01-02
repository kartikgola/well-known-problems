/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import linkedlist.DoublyNode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private DoublyNode<Integer> begin = new DoublyNode<>();
    private DoublyNode<Integer> end = new DoublyNode<>();
    Map<Integer, DoublyNode<Integer>> map = new HashMap<>();
    private final int CAPACITY;

    private DoublyNode<Integer> getLast() {
        if  (end.prev != begin)
            return end.prev;
        return null;
    }

    private void remove(DoublyNode<Integer> node) {
        DoublyNode<Integer> prev = node.prev;
        DoublyNode<Integer> next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addFirst(DoublyNode<Integer> node) {
        DoublyNode<Integer> next = begin.next;
        begin.next = node;
        node.prev = begin;
        node.next = next;
        next.prev = node;
    }

    private void move2Front(DoublyNode<Integer> node) {
        remove(node);
        addFirst(node);
    }

    public LRUCache(int cap) {
        CAPACITY = cap;
        begin.next = end;
        begin.prev = end;
        end.prev = begin;
        end.next = begin;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        DoublyNode<Integer> node = map.get(key);
        move2Front(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            move2Front(map.get(key));
            map.get(key).val = value;
        } else {
            if (map.size() == CAPACITY) {
                map.remove(getLast().key);
                remove(getLast());
            }
            DoublyNode<Integer> node = new DoublyNode<>(key, value);
            addFirst(node);
            map.put(key, node);
        }
    }
}
