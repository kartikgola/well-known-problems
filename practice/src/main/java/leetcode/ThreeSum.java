/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class ThreeSum {

    private List<List<Integer>> threeSumCount(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if ( nums.length < 3 ) return list;

        final int n = nums.length;
        Arrays.sort(nums);

        for ( int i = 0; i < n - 2; ++i ) {
            int j = i + 1;
            int k = n - 1;
            int sum = target - nums[i];
            if ( i == 0 || nums[i] != nums[i - 1] ) {
                while ( j < k ) {
                    if ( nums[j] + nums[k] == sum ) {
                        list.add( Arrays.asList(nums[i], nums[j], nums[k]) );
                        while ( j < k && nums[j] == nums[j + 1] ) ++j;
                        while ( j < k && nums[k] == nums[k - 1] ) --k;
                        ++j;
                        --k;
                    } else if ( nums[j] + nums[k] > sum ) --k;
                    else ++j;
                }
            }
        }

        return list;
    }

    // a+b+c=k
    // sum=k-a
    // diff=sum-b
    private List<List<Integer>> threeSumCountWithMap(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if ( nums.length < 3 ) return list;

        final int n = nums.length;
        final Map<Integer, Integer> map = new HashMap<>();
        int i, j, sum;

        for ( i = 0; i < n - 2; ++i ) {
            if ( i == 0 || nums[i] != nums[i - 1] ) {
                sum = target - nums[i];
                map.clear();
                for ( j = i + 1; j < n; ++j ) {
                    int diff = sum - nums[j];
                    if ( map.containsKey(diff) ) {
                        // TODO - Need to figure out a way to remove duplicates!
                        list.add(Arrays.asList(nums[i], nums[j], nums[map.get(diff)]));
                    } else {
                        map.put(nums[j], j);
                    }
                }
            }
        }

        return list;
    }
}
