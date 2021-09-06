/*
 * Author: Kartik Gola
 * Date: 9/6/21, 11:52 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

public class FirstBadVersion {

    boolean isBadVersion(int version) { return true; }

    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;

        while (l < r) {
            int m = l+(r-l)/2;
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }
}
