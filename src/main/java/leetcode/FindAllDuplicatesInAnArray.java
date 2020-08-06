/*
 * Author: Kartik Gola
 * Date: 8/6/20 10:19 PM
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL: https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */

package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {
        boolean[] set = new boolean[nums.length + 1];
        List<Integer> ans = new LinkedList<>();
        for ( int num : nums ) {
            if ( set[num] ) {
                ans.add(num);
            } else {
                set[num] = true;
            }
        }
        return ans;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for ( int num : nums )
            nums[Math.abs(num) - 1] *= -1;

        for ( int num : nums ) {
            if ( nums[Math.abs(num) - 1] > 0 ) {
                ans.add(Math.abs(num));
                nums[Math.abs(num) - 1] *= -1;
            }
        }

        return ans;
    }
}
