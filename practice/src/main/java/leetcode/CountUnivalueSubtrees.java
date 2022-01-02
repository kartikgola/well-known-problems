/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;

public class CountUnivalueSubtrees {

    int ans = 0;

    private boolean f(TreeNode root, int prev) {
        if (root != null) {
            boolean res = f(root.left, root.val);
            res &= f(root.right, root.val);
            if (res)
                ans++;
            return prev == 1001 || root.val == prev && res;
        }
        return true;
    }

    public int countUnivalSubtrees(TreeNode root) {
        f(root, 1001);
        return ans;
    }
}
