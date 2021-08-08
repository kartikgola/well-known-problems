/*
 * Author: Kartik Gola
 * Date: 6/18/21, 3:57 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/range-sum-query-mutable/
 */

package practice.leetcode;

import util.ds.tree.segment.RangeQueryType;
import util.ds.tree.segment.SegmentTree;

public class RangeSumQueryMutable {

    private final SegmentTree st;

    public RangeSumQueryMutable(int[] nums) {
        st = new SegmentTree(nums, RangeQueryType.Sum);
    }

    public void update(int index, int val) {
        st.update(index, val);
    }

    public int sumRange(int left, int right) {
        return st.query(left, right);
    }
}
