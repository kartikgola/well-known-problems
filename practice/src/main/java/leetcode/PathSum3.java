/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 {

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }

    // O(n^2)
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }


    private int ans = 0;
    private final Map<Integer, Integer> preSums = new HashMap<>(){{ put(0, 1); }};

    private void dfs(TreeNode root, int prevSum, int target) {
        if (root != null) {
            int currSum = prevSum + root.val;
            int diff = currSum - target;

            ans += preSums.getOrDefault(diff, 0);

            // Set counts for children
            preSums.put(currSum, preSums.getOrDefault(currSum, 0) + 1);

            dfs(root.left, currSum, target);
            dfs(root.right, currSum, target);

            // Remove currSum to prevent invalid values in adjacent subtree's dfs
            preSums.put(currSum, preSums.get(currSum)-1);
        }
    }

    // O(n)
    // Same approach as SubarraySumEqualsK.java
    public int pathSum2(TreeNode root, int target) {
        dfs(root, 0, target);
        return ans;
    }

}
