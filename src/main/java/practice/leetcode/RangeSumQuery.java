/*
 * Author: Kartik Gola
 * Date: 8/16/21, 10:33 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import util.ds.tree.segment.RangeQueryType;
import util.ds.tree.segment.SegmentTree;

public class RangeSumQuery {

    SegmentTree st;

    public RangeSumQuery(int[] nums) {
        st = new SegmentTree(nums, RangeQueryType.Sum);
    }

    public int sumRange(int left, int right) {
        return st.query(left, right);
    }
}
