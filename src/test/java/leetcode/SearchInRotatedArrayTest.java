/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

class SearchInRotatedArrayTest {

    @Test
    void findPivotTest() {
        SearchInRotatedSortedArray sr = new SearchInRotatedSortedArray();
        int[][] test = new int[][]{
                { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 },
                { 2, 3, 4, 5, 6, 7, 8, 9, 0, 1 },
                { 3, 4, 5, 6, 7, 8, 9, 0, 1, 2 },
                { 4, 5, 6, 7, 8, 9, 0, 1, 2, 3 },
                { 5, 6, 7, 8, 9, 0, 1, 2, 3, 4 },
                { 6, 7, 8, 9, 0, 1, 2, 3, 4, 5 },
                { 7, 8, 9, 0, 1, 2, 3, 4, 5, 6 },
                { 8, 9, 0, 1, 2, 3, 4, 5, 6, 7 },
                { 9, 0, 1, 2, 3, 4, 5, 6, 7, 8 }
        };

        int[] exp = new int[]{ 0, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        for ( int i = 0; i < test.length; ++i ) {
            assertEquals( exp[i], sr.search(test[i], test[i][0]) );
            System.out.println(sr.search(test[i], test[i][0]));
        }
    }

}