/*
 * Author: Kartik Gola
 * Date: 1/4/22, 12:20 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import tree.binary.TreeNode;
import util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDuplicateSubtrees {

    private Map<String, Pair<TreeNode, Integer>> map = new HashMap<>();

    // serializes tree to a string
    private String str(TreeNode root) {
        if (root == null)
            return "x";
        return root.val + "," + str(root.left) + "," + str(root.right);
    }

    private void f(TreeNode root) {
        if (root != null) {
            String str = str(root);
            if (map.containsKey(str))
                map.put(str, new Pair<>(map.get(str).getKey(), map.get(str).getValue()+1));
            else
                map.put(str, new Pair<>(root, 1));
            f(root.left);
            f(root.right);
        }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // since root cannot be duplicate with anyone, recurse for left & right
        f(root.left);
        f(root.right);
        return map.values().stream()
                .filter(pa -> pa.getValue() > 1)
                .map(Pair::getKey)
                .collect(Collectors.toList());
    }
}
