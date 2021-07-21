/*
 * Author: Kartik Gola
 * Date: 11/6/20, 7:17 PM
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 */

package practice.leetcode;

import java.util.Arrays;

public class FindTheSmallestDivisorGivenAThreshold {

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1,
            high = Arrays.stream(nums).max().getAsInt(),
            res = 1;

        while (low <= high) {
            final int div = low + (high - low) / 2;
            final int sum = Arrays.stream(nums)
                    .map(v -> (int) Math.ceil(v / (float)div))
                    .sum();

            if (sum <= threshold) {
                res = div;
                high = div - 1;
            } else {
                low = div + 1;
            }
        }

        return res;
    }
}
