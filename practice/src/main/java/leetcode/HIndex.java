/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
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
