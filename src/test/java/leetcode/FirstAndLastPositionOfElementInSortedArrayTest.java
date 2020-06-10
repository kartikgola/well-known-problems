/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

class FirstAndLastPositionOfElementInSortedArrayTest {

    @Test
    void searchRange() {

        FirstAndLastPositionOfElementInSortedArray f = new FirstAndLastPositionOfElementInSortedArray();

        int[] t = new int[]{1,1,1,1,2,2,2,3,3,4};
        assertArrayEquals( new int[]{-1,-1}, f.searchRange(t, 0) );
        assertArrayEquals( new int[]{0, 3}, f.searchRange(t, 1) );
        assertArrayEquals( new int[]{4, 6}, f.searchRange(t, 2) );
        assertArrayEquals( new int[]{7, 8}, f.searchRange(t, 3) );
        assertArrayEquals( new int[]{9, 9}, f.searchRange(t, 4) );
        assertArrayEquals( new int[]{-1, -1}, f.searchRange(t, 5) );
    }
}