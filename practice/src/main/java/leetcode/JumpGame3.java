/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class JumpGame3 {

    private boolean canReach(int[] arr, boolean[] vis, int i) {
        if (i < 0 || i >= arr.length || vis[i])
            return false;
        if (arr[i] == 0)
            return true;
        vis[i] = true;
        return canReach(arr, vis, i+arr[i]) || canReach(arr, vis, i-arr[i]);
    }

    public boolean canReach(int[] arr, int start) {
        return canReach(arr, new boolean[arr.length], start);
    }
}
