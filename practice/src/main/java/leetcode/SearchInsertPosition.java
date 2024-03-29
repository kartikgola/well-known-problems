/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;

public class SearchInsertPosition {

    private int getFirstOccurance(int[] nums, int to, int target) {
        int i = 0, j = to;
        while ( i < j ) {
            int m = i + (j - i) / 2;
            if ( nums[m] == target ) {
                j = m - 1;
            } else if ( nums[m] > target ) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    public int searchInsert(int[] nums, int target) {
        int idx = Arrays.binarySearch(nums, target);
        if ( idx < 0 ) {
            idx += 1;
            idx *= -1;
            return idx;
        }
        return getFirstOccurance(nums, idx, target);
    }
}
