/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | rattl.io
 */

package leetcode;

public class SearchInRotatedArray {

//    private int findPivot(int[] nums) {
//        final int n = nums.length;
//        int step = 1;
//        int p = 0;
//        for ( int i = 1; i < n && p != i; ) {
//            if ( nums[p] > nums[i] ) {
//                while ( p + 1 < n && nums[p] <= nums[p + 1] ) ++p;
//                if ( p + 1 < n ) {
//                    if ( nums[p + 1] < nums[p] ) {
//                        return p + 1;
//                    }
//                }
//            }
//            p = i;
//            step *= 2;
//            i += step;
//
//            if ( i + step >= n ) {
//                i = n - 1;
//            }
//        }
//        return 0;
//    }
//
//    public int search(int[] nums, int target) {
//        int p = findPivot(nums);
//        int left = Arrays.binarySearch(nums, 0, p, target);
//        int right = Arrays.binarySearch(nums, p, nums.length, target);
//
//        return Math.max(left, right) < 0 ? -1 : Math.max(left, right);
//    }

    public int findPivot(int[] nums) {
        final int n = nums.length;
        int l = 0, r = n - 1, m = 0;
        while ( l < r ) {
            m = l + (r - l) / 2;
            if ( nums[r] < nums[l] ) {
                if ( nums[m] < nums[l] ) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else {
                break;
            }
        }
        return l;
    }

    public int search(int[] nums, int target) {
        final int n = nums.length;
        if ( n == 0 ) return -1;
        return -1;
    }

}
