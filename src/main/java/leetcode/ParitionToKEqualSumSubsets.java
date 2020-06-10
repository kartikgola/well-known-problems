/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | rattl.io
 */

package leetcode;

import java.util.Arrays;

public class ParitionToKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] A, int k) {
        // 1 5 6 9 13 20
        if (k > A.length) return false;
        int sum = 0;
        for (int num : A) sum += num;
        if (sum % k != 0) return false;
        boolean[] visited = new boolean[A.length];
        Arrays.sort(A);
        return canPart(A, 0, A.length - 1, visited, sum / k, k);
    }

    public boolean canPart(int[] A, int sum, int st, boolean[] visited, int target, int k) {
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
