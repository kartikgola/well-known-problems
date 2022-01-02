/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

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
