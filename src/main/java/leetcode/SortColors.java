/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

public class SortColors {

    private final int INF = Integer.MAX_VALUE;

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        if ( nums.length < 2 ) return;
        final int n = nums.length;
        int two = INF, one = INF;

        for ( int i = 0; i < n; ++i ) {
            if ( nums[i] == 0 ) {
                if ( Math.min(one, two) < i ) {
                    final int min = Math.min(one, two);
                    if ( min == one ) {
                        if ( two == INF ) {
                            swap(nums, i, one);
                            while(one < n && nums[one] != 1) ++one;
                        } else {
                            swap(nums, i, one);
                            swap(nums, i, two);
                            while(one < n && nums[one] != 1) ++one;
                            while(two < n && nums[two] != 2) ++two;
                        }
                    } else {
                        swap(nums, i, two);
                        while(two < n && nums[two] != 2) ++two;
                    }
                }
            } else if ( nums[i] == 1 ) {
                if ( two < i ) {
                    swap(nums, i, two);
                    if ( one == INF ) {
                        one = two;
                    }
                    while(two < n && nums[two] != 2) ++two;
                } else if ( one == INF ) {
                    one = i;
                }
            } else if ( nums[i] == 2 && two == INF ) {
                two = i;
            }
        }
    }
}
