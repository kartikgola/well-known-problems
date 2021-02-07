/*
 * Author: Kartik Gola
 * Date: 08/02/2021, 00:14
 * Copyright (c) 2021 | https://rattl.io
 */

package util;

public class ArrayUtils {

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
