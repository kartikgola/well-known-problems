package leetcode;

import java.util.HashMap;
import java.util.Map;

class LRUNode {

    int key;
    int usage;
    LRUNode prev;
    LRUNode next;

    LRUNode(int key, int usage) {
        this.key = key;
        this.usage = usage;
    }

}

class LRUList {

    LRUNode first;
    int size = 0;

    public void add(LRUNode node) {
        if ( first == null ) {
            first = node;
            first.prev = node;
            first.next = node;
        } else {
            LRUNode last = first.prev;
            last.next = node;
            node.prev = last;
            node.next = first;
            first.prev = node;
        }
        ++size;
    }

    public void removeKey(int key) {
        if ( size > 0 ) {
            LRUNode f = first;
            LRUNode l = first.prev;
            while ( f.key != l.key ) {
                if ( f.key == key ) { ++size; removeNode(f); }
                if ( l.key == key ) { ++size; removeNode(l); }
                f = f.next;
                l = l.prev;
            }
            if ( f.key == key ) { ++size; removeNode(f); }
        }
    }

    private void removeNode(LRUNode node) {
        LRUNode prev = node.prev;
        LRUNode next = node.next;

        if ( first.key == node.key ) {
            if ( size == 1 ) {
                first = null;
            } else {
                first = first.next;
                prev.next = next;
                next.prev = prev;
            }
        } else {
            prev.next = next;
            next.prev = prev;
        }
        --size;
    }

}

public class LRUCache {

    private Map<Integer, Integer> store;
    private LRUList list;
    private int CAPACITY = 1;
    private int ops = 0;

    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        this.store = new HashMap<>();
        this.list = new LRUList();
    }

    public int get(int key) {
        if ( store.containsKey(key) ) {
            list.removeKey(key);
            list.add(new LRUNode(key, ++ops));
            return store.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        store.put(key, value);
        list.removeKey(key);
        list.add(new LRUNode(key, ++ops));
    }

}
