/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | rattl.io
 */

package leetcode;

import util.ArrayInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    private List<List<Integer>> fourSumCount(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if ( nums.length < 4 ) return list;

        final int n = nums.length;
        Arrays.sort(nums);

        for ( int i = 0; i < n - 3; ++i ) {
            int sum = target - nums[i];
            if ( i == 0 || nums[i] != nums[i - 1] ) {
                list.addAll(threeSumCount(nums, i + 1, n, sum, nums[i]));
            }
        }

        return list;
    }

    private List<List<Integer>> threeSumCount(int[] nums, int start, int end, int target, int head) {
        List<List<Integer>> list = new ArrayList<>();
        final int n = end;

        for ( int i = start; i < n - 2; ++i ) {
            int j = i + 1;
            int k = n - 1;
            int sum = target - nums[i];
            if ( i == start || nums[i] != nums[i - 1] ) {
                while ( j < k ) {
                    if ( nums[j] + nums[k] == sum ) {
                        list.add( Arrays.asList(head, nums[i], nums[j], nums[k]) );
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

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(reader.readLine());
        final int target = Integer.parseInt(reader.readLine());
        System.out.println(fourSumCount(
                ArrayInput.readArray(reader, N),
                target
        ));

    }
}
