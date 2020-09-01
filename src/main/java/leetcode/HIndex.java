/*
 * Author: Kartik Gola
 * Date: 8/11/20 10:11 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/h-index/
 */

package leetcode;

import java.util.Arrays;

public class HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = citations.length;
        for ( int ct : citations ) {
            if ( h > ct ) {
                h--;
            } else break;
        }
        return h;
    }
}
