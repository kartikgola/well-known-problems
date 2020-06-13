/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package ds;

import junit.framework.TestCase;

public class LazySegmentTreeTest extends TestCase {

    public void testQuery() {
    }

    public void testUpdate() {
        int[] arr = new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1};
        LazySegmentTree st = new LazySegmentTree(arr);

        assertEquals(1, st.query(2, 6) );
        st.update(2, 3, 1);
        assertEquals(3, st.query(2, 6) );
    }
}