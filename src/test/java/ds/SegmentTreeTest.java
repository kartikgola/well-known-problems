package ds;

import junit.framework.TestCase;

public class SegmentTreeTest extends TestCase {

    public void testQuery() {
    }

    public void testUpdate() {
        int[] arr = new int[]{-1, 0, 1, 4, 0, 3, 7, -2, 1};
        SegmentTree st = new SegmentTree(
                arr, SegmentTree.RangeQueryType.Maximum
        );

        assertEquals(7, st.query(2, 6) );
        st.update(6, 2);
        assertEquals(4, st.query(2, 6) );
    }
}