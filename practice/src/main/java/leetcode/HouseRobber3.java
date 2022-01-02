/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

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
