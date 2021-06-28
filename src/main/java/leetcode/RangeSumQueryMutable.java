/*
 * Author: Kartik Gola
 * Date: 6/18/21, 3:57 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/range-sum-query-mutable/
 */

package leetcode;

import util.ds.tree.segment.SegmentTree;

public class RangeSumQueryMutable {

    private final SegmentTree st;

    public RangeSumQueryMutable(int[] nums) {
        st = new SegmentTree(nums, SegmentTree.RangeQueryType.Sum);
    }

    public void update(int index, int val) {
        st.update(index, val);
    }

    public int sumRange(int left, int right) {
        return st.query(left, right);
    }
}
