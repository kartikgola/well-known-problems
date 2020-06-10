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
        int[] arr = new int[]{-1, 0, 1, 4, 0, 3, 7, -2, 1};
        LazySegmentTree st = new LazySegmentTree(arr);

        assertEquals(15, st.query(2, 6) );
        st.update(2, 6, 1);
        assertEquals(20, st.query(2, 6) );
    }
}