/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
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
