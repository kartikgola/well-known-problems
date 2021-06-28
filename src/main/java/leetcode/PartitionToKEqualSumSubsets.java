/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package leetcode;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] A, int k) {
        if (k > A.length) return false;
        int sum = 0;
        for (int num : A) sum += num;
        if (sum % k != 0) return false;
        boolean[] visited = new boolean[A.length];
        // Sorting here is being done to speed up the process of grouping
        // Since a big number, if taken first, is less probable to be grouped with other numbers
        Arrays.sort(A);
        return canPart(A, 0, A.length - 1, visited, sum / k, k);
    }

    private boolean canPart(int[] A, int sum, int st, boolean[] visited, int target, int k) {
        if (k == 0) return true;
        if (sum == target && canPart(A, 0, A.length - 1, visited, target, k - 1))
            return true;
        for (int i = st; i >= 0; --i) {
            if (!visited[i] && sum + A[i] <= target) {
                visited[i] = true;
                if (canPart(A, sum + A[i], i - 1, visited, target, k))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }

}
