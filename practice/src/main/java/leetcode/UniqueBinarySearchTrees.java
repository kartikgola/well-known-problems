/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        // trees[i] = No. of BSTs that can be made with 'i' number of nodes
        int[] trees = new int[n + 1];
        trees[0] = trees[1] = 1;

        // Choose 'i' as root of BST
        for ( int i = 2; i <= n; ++i ) {
            for ( int j = 1; j <= i; ++j ) {
                // Add number of BSTs possible with 'j-1' nodes + number of BSTs possible with 'i-j' nodes
                trees[i] += trees[j - 1] * trees[i - j];
            }
        }
        return trees[n];
    }

    private Integer[] dp = new Integer[20];

    public int numTrees2(int n) {
        if (n <= 1)
            return 1;
        if (dp[n] != null)
            return dp[n];
        int ans = 0;
        for (int root = 1; root <= n; ++root)
            ans += numTrees2(root-1) * numTrees2(n-root);
        return dp[n] = ans;
    }

}
