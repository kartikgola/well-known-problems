/*
 * Author: Kartik Gola
 * Date: 6/25/20 7:05 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int tt = nums[0];
        int hr = nums[0];

        do {
            tt = nums[tt];
            hr = nums[nums[hr]];
        } while ( tt != hr );

        tt = nums[0];
        while ( tt != hr ) {
            tt = nums[tt];
            hr = nums[hr];
        }

        return tt;
    }
}
