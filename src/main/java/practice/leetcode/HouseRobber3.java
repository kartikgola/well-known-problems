/*
 * Author: Kartik Gola
 * Date: 14/10/2020, 23:01
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL: https://leetcode.com/problems/house-robber-ii/
 */

package practice.leetcode;

import util.ds.tree.binary.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber3 {

    private Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root != null) {
            if (map.containsKey(root))
                return map.get(root);
            int ans = root.val;
            if (root.left != null)
                ans += rob(root.left.left) + rob(root.left.right);
            if (root.right != null)
                ans += rob(root.right.left) + rob(root.right.right);
            ans = Math.max(ans, rob(root.left) + rob(root.right));
            map.put(root, ans);
            return ans;
        }
        return 0;
    }

}
