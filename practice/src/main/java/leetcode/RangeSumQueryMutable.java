/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.segment.RangeQueryType;
import tree.segment.SegmentTree;

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
