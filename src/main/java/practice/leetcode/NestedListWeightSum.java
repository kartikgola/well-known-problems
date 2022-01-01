/*
 * Author: Kartik Gola
 * Date: 1/1/22, 10:43 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.List;

public class NestedListWeightSum {

    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public void setInteger(int value);
        public void add(NestedInteger ni);
        public List<NestedInteger> getList();
    }

    private int depthSum(List<NestedInteger> nl, int depth) {
        int ans = 0;
        for (NestedInteger ni: nl) {
            if (ni.isInteger()) {
                ans += depth * ni.getInteger();
            } else {
                ans += depthSum(ni.getList(), depth+1);
            }
        }
        return ans;
    }

    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }
}
