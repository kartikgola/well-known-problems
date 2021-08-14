/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {

    private List<List<Integer>> twoSumCount(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);
        final int n = nums.length;

        int i = 0, j = n - 1;
        while ( i < j ) {
            if ( nums[i] + nums[j] == target ) {
                while ( i < j && nums[i] == nums[i + 1] ) ++i;
                while ( i < j && nums[j] == nums[j - 1] ) --j;
                list.add(Arrays.asList(nums[i], nums[j]));
                ++i;
                --j;
            } else if ( nums[i] + nums[j] < target ) ++i;
            else --j;
        }

        return list;
    }

}