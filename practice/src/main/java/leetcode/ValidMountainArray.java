/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {
        if (arr.length <= 2)
            return false;

        boolean strictInc = true;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] == arr[i - 1]) // Adj. values are equal, return false
                return false;
            else if (arr[i] > arr[i - 1]) { // Value increases
                if (!strictInc) // If we're going down, return false
                    return false;
            } else if (!strictInc || i > 1) { // Value decreases
                    strictInc = false; // We're going down OR we have crossed index 1, make strictInc = false
            } else return false;
        }

        return !strictInc; // It should always end downhill!
    }

    public boolean validMountainArray2(int[] arr) {
        final int n = arr.length;
        int i = 0;
        // climb up
        while (i + 1 < n && arr[i] < arr[i + 1])
            ++i;

        if (i == 0 || i == n - 1)
            return false;

        // climb down
        while (i + 1 < n && arr[i] < arr[i + 1])
            ++i;

        return i == n - 1;
    }
}
