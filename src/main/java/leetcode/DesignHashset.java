/*
 * Author: Kartik Gola
 * Date: 02/08/20, 1:03 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/design-hashset/
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class DesignHashset {

    private List<List<Integer>> map = new ArrayList<>();
    private final int BUCKETS = 1000;

    private int hash(int key) {
        return (((key + 31) % BUCKETS) + 999983) % BUCKETS;
    }

    /** Initialize your data structure here. */
    public DesignHashset() {
        for ( int i = 0; i < BUCKETS; ++i ) {
            map.add(new ArrayList<>());
        }
    }

    public void add(int key) {
        final int hashVal = hash(key);
        for ( Integer val : map.get(hashVal) ) {
            if ( val == key )
                return;
        }
        map.get(hashVal).add(key);
    }

    public void remove(int key) {
        final int hashVal = hash(key);
        final List<Integer> list = map.get(hashVal);
        for ( int i = 0; i < list.size(); ++i ) {
            if ( list.get(i) == key ) {
                list.set(i, list.get(list.size() - 1));
                list.remove(list.size() - 1);
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        final int hashVal = hash(key);
        final List<Integer> list = map.get(hashVal);
        for ( Integer elem : list ) {
            if ( elem == key )
                return true;
        }
        return false;
    }
}
