/*
 * Author: Kartik Gola
 * Date: 08/02/2021, 21:30
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package leetcode;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> it;
    private Integer val = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        it = iterator;
        if (it.hasNext())
            val = it.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return val;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer temp = val;
        val = it.hasNext() ? it.next() : null;
        return temp;
    }

    @Override
    public boolean hasNext() {
        return val != null;
    }
}
