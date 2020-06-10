/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import util.ArrayInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(reader.readLine());
        final int target = Integer.parseInt(reader.readLine());
        System.out.println(twoSumCount(
                ArrayInput.readArray(reader, N),
                target
        ));

    }
}
