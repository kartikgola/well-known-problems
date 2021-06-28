/*
 * Author: Kartik Gola
 * Date: 10/11/2020, 19:13
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/flipping-an-image/
 */

package leetcode;

public class FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] arr: A) {
            for (int l = 0, r = arr.length - 1; l <= r; ++l, --r) {
                int temp = arr[l];
                arr[l] = arr[r] == 1 ? 0 : 1;
                arr[r] = temp == 1 ? 0 : 1;
            }
        }
        return A;
    }
}
