/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

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
